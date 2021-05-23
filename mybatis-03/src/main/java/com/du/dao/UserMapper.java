package com.du.dao;

import com.du.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserLimit(Map<String, Integer> map);
}
