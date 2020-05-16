package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
