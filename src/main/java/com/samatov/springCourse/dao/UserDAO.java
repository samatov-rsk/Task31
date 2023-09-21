package com.samatov.springCourse.dao;

import com.samatov.springCourse.model.User;

import java.util.List;

public interface UserDAO {

    List<User>getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(long id, User user);
}