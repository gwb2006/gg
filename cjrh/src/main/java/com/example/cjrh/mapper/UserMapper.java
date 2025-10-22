package com.example.cjrh.mapper;

import com.example.cjrh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问接口
 * 使用Spring Data JPA进行数据库操作
 */
@Repository
public interface UserMapper extends JpaRepository<User, Long> {
    // Spring Data JPA会自动实现基本的CRUD操作
    // 这里可以添加自定义的查询方法
    
    /**
     * 根据用户名查找用户
     */
    User findByUsername(String username);
}