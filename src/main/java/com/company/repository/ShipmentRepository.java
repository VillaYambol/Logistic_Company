package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entities.Shipment;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {

}
