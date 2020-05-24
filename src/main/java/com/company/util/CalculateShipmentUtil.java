package com.company.util;

import com.company.entities.Shipment;

public class CalculateShipmentUtil {

	public static double calculateShipmentPrice(Shipment shipment) {
		return shipment.getPrice()*shipment.getWeight();
	}
}
