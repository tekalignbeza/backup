package com.mybot.rest.config.security.domain;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtAuthenticationResponse{

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
