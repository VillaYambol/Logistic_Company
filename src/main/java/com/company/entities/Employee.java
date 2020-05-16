package com.company.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {
	private String name;
	private EmployeeType employeetype;

	private List<Shipment> shipments;

	private Office office;

	public Employee() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	@JoinColumn
	@ManyToOne
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "question_text", nullable = false, unique = false, updatable = true)
	public EmployeeType getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(EmployeeType employeetype) {
		this.employeetype = employeetype;
	}

}