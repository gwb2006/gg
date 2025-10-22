package com.example.cjrh.service.impl;

import com.example.cjrh.entity.User;
import com.example.cjrh.mapper.UserMapper;
import com.example.cjrh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务实现类
 * 实现用户相关的业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userMapper.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User save(User user) {
        // Spring Data JPA的save方法同时支持新增和更新
        return userMapper.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }
}