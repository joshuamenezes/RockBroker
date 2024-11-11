package com.jm.rockbroker_backend.repository;

import com.jm.rockbroker_backend.entity.User;
import com.jm.rockbroker_backend.repository.customQueries.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for queries related to Users. The Jpa repository contains basic queries, and the custom class contains queries
 * that I've defined (non-basic)
 */
public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom {

}
