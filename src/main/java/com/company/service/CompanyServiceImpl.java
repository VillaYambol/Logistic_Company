package com.company.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Company;
import com.company.entities.Office;
import com.company.entities.Shipment;
import com.company.repository.CompanyRepository;
import com.company.repository.OfficeRepository;
import com.company.repository.ShipmentRepository;
import com.company.util.CalculateShipmentUtil;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public Company createCompany(Company company) {
		return this.companyRepository.save(company);
	}

	@Override
	public double calculateIncome(LocalDate startDate, LocalDate endDate){
		List<Shipment> allShipments = this.shipmentRepository.findAll();
		double income = 0.0;
		for(Shipment shipment : allShipments) {
			if(shipment.getReceivedDate().isBefore(endDate) && shipment.getReceivedDate().isAfter(startDate)) {
				Optional<Office> office = this.officeRepository.findByAddress(shipment.getAddress());
				if(!office.isPresent()) {
					income += 2;
				}
				income += CalculateShipmentUtil.calculateShipmentPrice(shipment);
			}
		}
		return income;
	}
	
}
