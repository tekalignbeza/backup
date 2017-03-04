/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybot.application.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author tek
 */
@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;
    // creates a simple e-mail object

    public boolean send(String sendTo) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(sendTo);
            email.setSubject("Welcome");
            email.setText(
                    "You've successfully signed up for an account. Your account has been created and you may now sign in our website with your email address "+sendTo+". You may sign in at any time at mybot.com.\n" +
                    "\n" +
                    "Sincerely,\n" +
                    "\n" +
                    "The Mybot Team");
            mailSender.send(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
