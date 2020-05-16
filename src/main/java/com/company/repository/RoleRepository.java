package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByAuthority(String authority);
}
