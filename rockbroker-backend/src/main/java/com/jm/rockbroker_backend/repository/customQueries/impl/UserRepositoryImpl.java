package com.jm.rockbroker_backend.repository.customQueries.impl;

import com.jm.rockbroker_backend.entity.User;
import com.jm.rockbroker_backend.repository.customQueries.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

/**
 * Implementation of custom user queries. We can ignore the unused class warning here because spring will autowire
 * the name to the UserRepository class.
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<User> findByUserName(String userName) {
        // JPQL (Java Persistence Query Language)
        String query = "SELECT u FROM User u WHERE u.userName = :userName";
        return entityManager.createQuery(query, User.class)
                .setParameter("userName", userName)
                .getResultStream()
                .findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "Select u FROM User u WHERE u.email = :email";
        return entityManager.createQuery(query, User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
