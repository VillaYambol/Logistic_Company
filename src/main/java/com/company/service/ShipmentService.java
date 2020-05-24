package com.company.service;

import java.util.List;

import com.company.entities.Shipment;

public interface ShipmentService {

	List<Shipment> findAllShipments();

	Shipment findShipmentById(String id);

	Shipment createShipment(Shipment shipment);

	Shipment updateShipment(String id, Shipment shipment);

	void deleteShipment(String id);

	List<Shipment> getRegistestredShipments();
}
