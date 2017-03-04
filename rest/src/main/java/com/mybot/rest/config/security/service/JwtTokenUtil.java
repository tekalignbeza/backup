package com.mybot.rest.config.security.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.mybot.rest.config.security.domain.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil{

    static final String USERNAME = "sub";
    static final String CREATED = "created";
    private final Log logger = LogFactory.getLog(this.getClass());
    private String secret = "testme";

    private Long expiration =1440000L;

    public String getUsernameFromToken(String token) {
        logger.info("checking authentication user " + token.length());
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
            logger.info("urs " + username);
        } catch (Exception e) {
            username = null;
            logger.info("err " + e.getMessage());
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

  
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

   
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(USERNAME, userDetails.getUsername());
        claims.put(CREATED, new Date());
        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token));
    }
}