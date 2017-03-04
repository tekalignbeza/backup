package com.mybot.rest.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mybot.domain.user.User;
import com.mybot.integration.user.UserDao;
import com.mybot.rest.config.security.domain.JwtUserFactory;

@Service("jwtUserDetailsServiceImpl")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
