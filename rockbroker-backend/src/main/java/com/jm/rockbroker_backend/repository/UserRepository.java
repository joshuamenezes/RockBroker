package com.jm.rockbroker_backend.repository;

import com.jm.rockbroker_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //TODO: Need to find out how to define custom queries...
    public User findByUserName(String userName);

    public User findByEmail(String email);
}
