package com.abc.userregistration.controller;

import com.abc.userregistration.common.response.ApiResponse;
import com.abc.userregistration.model.User;
import com.abc.userregistration.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/profile")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        super();
        this.userService=userService;
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){

        return userService.createUser(user);
    }
    @GetMapping("{userId}")
    public ApiResponse getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public ApiResponse updateUserById(@RequestBody User user,@PathVariable("userId") int userId){
        return userService.updateUserById(user,userId);
    }
    @PutMapping("/password/update/{userId}")
    public ApiResponse updateUserByPassword(@RequestBody User user,@PathVariable("userId") int userId){
        return userService.updateUserByPassword(user,userId);
    }

}
