package com.company.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@Entity
@Table(name="shipments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shipment extends BaseEntity{
	private String address;
	private double weight;
	private double price;
	private Client recipient;
	private Client sender;
	private Employee employee;
	private LocalDate receivedDate;
	
	public Shipment() {
	}

	@Column(name = "shipment_address", nullable = false, unique = false, updatable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "shipment_weight", nullable = false, unique = false, updatable = true)
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JoinColumn
	@ManyToOne
	public Client getRecipient() {
		return recipient;
	}

	public void setRecipient(Client recipient) {
		this.recipient = recipient;
	}

	@ManyToOne
	@JoinColumn
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@JoinColumn
	@ManyToOne
	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	@Column(name = "date",updatable = true,nullable = false,unique = false)
	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shipment other = (Shipment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

}
