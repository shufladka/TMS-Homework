package org.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tms.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}