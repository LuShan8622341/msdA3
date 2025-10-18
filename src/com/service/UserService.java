package com.service;

import com.entity.User;

/**
 * 用户服务接口
 */
public interface UserService {
    // 用户登录
    boolean login(String username, String password);

    // 用户注册
    User register(User user);
}