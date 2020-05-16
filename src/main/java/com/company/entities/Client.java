package com.company.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends User {
	
	private List<Shipment> sentShipments;
	private List<Shipment> recievedShipments;

	public Client() {

	}
	
	public List<Shipment> getSentShipments() {
		return sentShipments;
	}

	public void setSentShipments(List<Shipment> sentShipments) {
		this.sentShipments = sentShipments;
	}

	public List<Shipment> getRecievedShipments() {
		return recievedShipments;
	}

	public void setRecievedShipments(List<Shipment> recievedShipments) {
		this.recievedShipments = recievedShipments;
	}

}
