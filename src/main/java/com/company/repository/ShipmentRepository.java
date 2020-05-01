package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {

}
