package com.mybot.application.search;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.AMQP.BasicProperties;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.UUID;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.springframework.util.ResourceUtils;

//TODO Implement the new SDK
public class RabbitmqService {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue_testsdk";
    private String replyQueueName;
    private QueueingConsumer consumer;
    private static final String CLIENT_KEY = "classpath:key/client/keycert.p12";
    private static final String SERVER_KEY = "classpath:key/server/test";

    public RabbitmqService() throws Exception {

        FileInputStream client = new FileInputStream(ResourceUtils.getFile(CLIENT_KEY));
        FileInputStream server = new FileInputStream(ResourceUtils.getFile(SERVER_KEY));

        char[] keyPassphrase = "test1234".toCharArray();
        char[] trustPassphrase = "test1234".toCharArray();
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(client, keyPassphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, trustPassphrase);

        KeyStore tks = KeyStore.getInstance("JKS");
        tks.load(server, trustPassphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(tks);

        SSLContext c = SSLContext.getInstance("TLSv1.1");
        c.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("107.155.105.165");
        factory.setPort(5671);
        factory.useSslProtocol(c);
        // Tells the library to setup the default Key and Trust managers for you
        // which do not do any form of remote serve
        connection = factory.newConnection();
        channel = connection.createChannel();
        replyQueueName = channel.queueDeclare().getQueue();
        consumer = new QueueingConsumer(channel);
        channel.basicConsume(replyQueueName, true, consumer);
    }

    public String call(String message) throws Exception {
        String response = null;
        String corrId = UUID.randomUUID().toString();

        BasicProperties props = new BasicProperties.Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            if (delivery.getProperties().getCorrelationId().equals(corrId)) {
                response = new String(delivery.getBody(), "UTF-8");
                break;
            }
        }

        return response;
    }

    public void close() throws Exception {
        connection.close();
    }

}
