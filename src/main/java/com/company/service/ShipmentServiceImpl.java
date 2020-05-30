package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entities.Shipment;
import com.company.entities.User;
import com.company.repository.ShipmentRepository;
import com.company.repository.UserRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepository;

	@Autowired
	private UserRepository userRepository;

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
		List<User> employees = this.userRepository.findAll();
		for (User employee : employees) {
			registred.addAll(employee.getShipments());
		}
		return registred;
	}
}
