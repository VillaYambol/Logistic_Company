package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.entities.Employee;
import com.company.entities.Shipment;
import com.company.repository.EmployeeRepository;
import com.company.repository.ShipmentRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Employee> findAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {

		return this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		this.employeeRepository.delete(employee);

	}

	@Override
	public void registrateShipment(Employee employee, Shipment shipment) {
		this.employeeRepository.findById(employee.getId()).get().getShipments().add(shipment);

	}
}
