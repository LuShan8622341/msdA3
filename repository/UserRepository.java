package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户实体数据访问接口
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据用户名查询用户（用于登录验证）
    User findByUsername(String username);
}