package com.samatov.springCourse.service;

import com.samatov.springCourse.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Integer userId);

    void addUser(User user);

    void removeUser(Integer userId);

    void updateUser(Integer userId, User user);

}