package com.abc.authenticationservice.controller;


import com.abc.authenticationservice.common.response.ApiResponse;
import com.abc.authenticationservice.common.util.JwtUtil;
import com.abc.authenticationservice.model.JwtRequest;
import com.abc.authenticationservice.service.impl.JwtService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class JwtController {

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;
    private JwtService jwtService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getEmailId(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = jwtService.loadUserByUsername(jwtRequest.getEmailId());

        final String token =
                jwtUtil.generateToken(userDetails);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Success");
        UUID instanceId = UUID.randomUUID();
        Map<String,String> data = new HashMap<>();

        data.put("instanceId", String.valueOf(instanceId));
        data.put("token",token);
        data.put("validTill", String.valueOf(jwtUtil.extractExpiration(token)));

        apiResponse.setData(data);

        return  apiResponse;
    }
}
