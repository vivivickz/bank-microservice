package com.abc.userregistration.service;

import com.abc.userregistration.common.response.ApiResponse;
import com.abc.userregistration.model.User;

public interface UserService {
    User createUser(User user);
    ApiResponse getUserById(int userId);
    ApiResponse updateUserById(User user, int userId);

    ApiResponse updateUserByPassword(User user,int userId);

}
