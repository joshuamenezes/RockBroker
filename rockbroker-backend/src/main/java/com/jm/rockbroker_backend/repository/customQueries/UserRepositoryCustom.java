package com.jm.rockbroker_backend.repository.customQueries;

import com.jm.rockbroker_backend.entity.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);
}
