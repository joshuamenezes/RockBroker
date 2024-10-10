package com.jm.rockbroker_backend.repository;

import com.jm.rockbroker_backend.entity.Rock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RockRepository extends JpaRepository<Rock, Long> {
}
