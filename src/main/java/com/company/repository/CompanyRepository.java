package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
