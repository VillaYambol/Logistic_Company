package com.company.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.entities.Shipment;
import com.company.entities.User;
import com.company.models.service.UserServiceModel;
import com.company.service.ShipmentService;
import com.company.service.UserService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController extends BaseController {

	private final ShipmentService shipmentService;
	private final UserService userService;
	private final ModelMapper modelMapper;

	@Autowired
	public ShipmentController(ShipmentService shipmentService, UserService userService, ModelMapper modelMapper) {
		this.shipmentService = shipmentService;
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/add")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ModelAndView addShipment(ModelAndView modelAndView, @ModelAttribute(name = "model") Shipment model) {
		modelAndView.addObject("model", model);
		return super.view("add-shipment");
	}

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	public ModelAndView addShipmentConfirm(Principal principal, ModelAndView modelAndView,
			@ModelAttribute(name = "model") Shipment model) {
		model.setReceivedDate(LocalDate.now().plusDays(10));
		model.setSender(this.modelMapper.map(userService.findUserByUserName(principal.getName()), User.class));
		Shipment shipment = this.shipmentService.createShipment(model);
		modelAndView.addObject(shipment);
		return super.redirect("/home");
	}

}
