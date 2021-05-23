package com.du.dao;

import com.du.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserlike(String value);

    int addUser(Map<String, Object> map);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
