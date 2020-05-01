package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {

}
