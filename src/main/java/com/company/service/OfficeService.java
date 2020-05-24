package com.company.service;

import java.util.List;

import com.company.entities.Office;

public interface OfficeService {

	List<Office> findAllOffices();

	Office findById(String id);

	Office createOffice(Office office);

	void deleteOffice(String id);

	Office updateAddress(Office office, String address);
}
