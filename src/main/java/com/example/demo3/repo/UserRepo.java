package com.example.demo3.repo;

import com.example.demo3.EntityManagerProvider;
import com.example.demo3.model.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserRepo {



    public static User findUserByUsernameAndPassword(String username, String password) {
        try {
            EntityManager entityManager;
            entityManager=EntityManagerProvider.getEntityManager();
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
