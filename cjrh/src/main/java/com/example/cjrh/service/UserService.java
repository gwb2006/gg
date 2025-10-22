package com.example.cjrh.service;

import com.example.cjrh.entity.User;
import java.util.List;

/**
 * 用户服务接口
 * 定义用户相关的业务逻辑方法
 */
public interface UserService {
    /**
     * 获取所有用户
     */
    List<User> findAll();

    /**
     * 根据ID获取用户
     */
    User findById(Long id);

    /**
     * 保存用户
     */
    User save(User user);

    /**
     * 根据ID删除用户
     */
    void deleteById(Long id);
}