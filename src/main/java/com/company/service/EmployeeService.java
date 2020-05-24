package com.company.service;

import java.util.List;


import com.company.entities.Employee;
import com.company.entities.Shipment;

public interface EmployeeService {
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(String id);
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void registrateShipment(Employee employee,Shipment shipment);
}
