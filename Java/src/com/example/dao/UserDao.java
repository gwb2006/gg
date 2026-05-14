package com.example.dao;

import com.example.entity.User;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "123456", "管理员"));
        users.put("zhangsan", new User("zhangsan", "123456", "张三"));
        users.put("lisi", new User("lisi", "123456", "李四"));
        users.put("wangwu", new User("wangwu", "123456", "王五"));
    }

    public static User login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public static User findByUsername(String username) {
        if (username == null) {
            return null;
        }
        return users.get(username);
    }
}
