package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口控制器
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     */
    @PostMapping("/login")
    public ApiResponse<String> login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        if (userService.login(username, password)) {
            return ApiResponse.success("Login successful");
        } else {
            return ApiResponse.error("Invalid username or password");
        }
    }

    /**
     * 用户注册接口
     */
    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody User user) {
        try {
            User newUser = userService.register(user);
            return ApiResponse.success(newUser);
        } catch (RuntimeException e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}