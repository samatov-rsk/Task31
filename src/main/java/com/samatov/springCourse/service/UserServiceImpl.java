package com.samatov.springCourse.service;

import com.samatov.springCourse.dao.UserDAO;
import com.samatov.springCourse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Integer userId) {
        userDAO.removeUser(userId);
    }

    @Transactional
    @Override
    public void updateUser(Integer userId, User user) {
        userDAO.updateUser(userId, user);
    }

}