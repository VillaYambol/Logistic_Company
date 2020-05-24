package com.company.service;

import java.time.LocalDate;

import com.company.entities.Company;

public interface CompanyService {
	Company createCompany(Company company);
	double calculateIncome(LocalDate startDate, LocalDate endDate);
}
