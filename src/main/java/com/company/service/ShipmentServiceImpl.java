package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Employee;
import com.company.entities.Shipment;
import com.company.repository.EmployeeRepository;
import com.company.repository.ShipmentRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Shipment> findAllShipments() {
		List<Shipment> shipments = shipmentRepository.findAll();
		return shipments;
	}

	@Override
	public Shipment findShipmentById(String id) {
		return shipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Shipment createShipment(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public Shipment updateShipment(String id, Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public void deleteShipment(String id) {
		Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		shipmentRepository.delete(shipment);
	}

	@Override
	public List<Shipment> getRegistestredShipments() {
		List<Shipment> registred = new ArrayList<>();
		List<Employee> employees = this.employeeRepository.findAll();
		for (Employee employee : employees) {
			registred.addAll(employee.getShipments());
		}
		return registred;
	}
}
