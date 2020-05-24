package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.entities.Company;
import com.company.entities.Office;
import com.company.repository.CompanyRepository;
import com.company.repository.OfficeRepository;

public class OfficeServiceImpl implements OfficeService {

	@Autowired
	OfficeRepository officeRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Office> findAllOffices() {
		return this.officeRepository.findAll();
	}

	@Override
	public Office findById(String id) {
		return this.officeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Office createOffice(Office office) {
		Company company = this.companyRepository.findAll().get(0);
		office.setCompany(company);
		return this.officeRepository.save(office);
	}

	@Override
	public void deleteOffice(String id) {
		this.officeRepository.deleteById(id);
	}

	@Override
	public Office updateAddress(Office office, String address) {
		Office updatedOffice = this.findById(office.getId());
		updatedOffice.setAddress(address);
		return this.officeRepository.save(updatedOffice);
	}

}
