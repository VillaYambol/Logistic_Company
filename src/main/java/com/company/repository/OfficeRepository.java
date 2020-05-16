package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Office;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

}
