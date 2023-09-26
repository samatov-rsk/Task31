package com.samatov.springCourse.dao;

import com.samatov.springCourse.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String jpql = "select u from User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(Integer userId) {
        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new RuntimeException("User not found by id %s".formatted(userId));
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(Integer userId) {
        entityManager.remove(getUserById(userId));
    }

    @Override
    public void updateUser(Integer userId, User user) {
        entityManager.merge(user);
    }

}