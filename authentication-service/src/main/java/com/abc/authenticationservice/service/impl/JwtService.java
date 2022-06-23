package com.abc.authenticationservice.service.impl;


import com.abc.authenticationservice.integration.repository.JwtRepository;
import com.abc.authenticationservice.model.JwtRequest;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@AllArgsConstructor

public class  JwtService implements UserDetailsService {

    private JwtRepository jwtRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        JwtRequest existingUser = jwtRepository.findByEmailId(emailId).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                existingUser.getEmailId(), existingUser.getPassword(), new ArrayList<>());

    }
}