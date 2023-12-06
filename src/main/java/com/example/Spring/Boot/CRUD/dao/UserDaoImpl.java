package com.example.Spring.Boot.CRUD.dao;

import com.example.Spring.Boot.CRUD.model.User;
import org.springframework.stereotype.Repository;


import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("From User",User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void addUser(User user) {
    entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
    entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public void editUser(User user) {
    entityManager.merge(user);
    }
}
