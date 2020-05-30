//package com.company.entities;
//
//import java.util.List;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "clients")
//public class Client extends User {
//
//
//	private List<Shipment> sentShipments;
//	private List<Shipment> receivedShipments;
//
//	public Client() {
//
//	}
//
//	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
//	public List<Shipment> getSentShipments() {
//		return sentShipments;
//	}
//
//	public void setSentShipments(List<Shipment> sentShipments) {
//		this.sentShipments = sentShipments;
//	}
//
//	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
//	public List<Shipment> getReceivedShipments() {
//		return receivedShipments;
//	}
//
//	public void setReceivedShipments(List<Shipment> receivedShipments) {
//		this.receivedShipments = receivedShipments;
//	}
//
//}
