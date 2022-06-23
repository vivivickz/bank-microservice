package com.abc.userregistration.service.impl;

import com.abc.userregistration.common.response.ApiResponse;
import com.abc.userregistration.integration.repository.UserRepository;

import com.abc.userregistration.model.User;
import com.abc.userregistration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public ApiResponse getUserById(int userId) {

        ApiResponse apiResponse = new ApiResponse();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User ID not found"));
        Map<String,User> data = new HashMap<>();
        data.put("user", user);
        apiResponse.setData(data);
        return apiResponse;
    }

    @Override
    public ApiResponse updateUserById(User user, int userId) {
        HttpHeaders headers = new HttpHeaders();
        String secretCode = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaXZ5YUBnbWFpbC5jb20iLCJleHAiOjE2NTUwMTQ2NDgsImlhdCI6MTY1NTAxNDA0OH0.DQaCGD1-XAqf0RIijxjdCuV5taD-LYs7HittUA-68Cs";
        headers.add("Authorization", secretCode);

        ApiResponse apiResponse = new ApiResponse();

        User exsistingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User ID not found"));
        exsistingUser.setFirstName(user.getFirstName());
        exsistingUser.setLastName(user.getLastName());
        exsistingUser.setGender(user.getGender());
        exsistingUser.setDob(user.getDob());
        exsistingUser.setEmailId(user.getEmailId());
        exsistingUser.setPanNumber(user.getPanNumber());
        exsistingUser.setPhoneNumber(user.getPhoneNumber());
        exsistingUser.setAddress(user.getAddress());
        exsistingUser.setPermanentAddress(user.getPermanentAddress());

        userRepository.save(exsistingUser);

        Map<String,User> data = new HashMap<>();
        data.put("user", user);
        apiResponse.setData(data);
        return apiResponse;

    }

    @Override
    public ApiResponse updateUserByPassword(User user, int userId) {
        HttpHeaders headers = new HttpHeaders();
        String secretCode = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaXZ5YUBnbWFpbC5jb20iLCJleHAiOjE2NTUwMTQ2NDgsImlhdCI6MTY1NTAxNDA0OH0.DQaCGD1-XAqf0RIijxjdCuV5taD-LYs7HittUA-68Cs";
        headers.add("Authorization", secretCode);

        ApiResponse apiResponse = new ApiResponse();

        User exsistingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User ID not found"));

        exsistingUser.setEmailId(user.getEmailId());
        exsistingUser.setPassword(user.getPassword());

        userRepository.save(exsistingUser);

        Map<String,String> data = new HashMap<>();
        data.put("email",user.getEmailId());
        data.put("password", user.getPassword());
        apiResponse.setData(data);
        return apiResponse;

    }


}

