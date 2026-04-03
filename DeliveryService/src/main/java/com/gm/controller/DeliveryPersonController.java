package com.gm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.DeliveryPersonRequestDto;
import com.gm.dto.DeliveryPersonResponseDto;
import com.gm.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryPersonController {
	
	public final DeliveryService deliveryService;
	
	public DeliveryPersonController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	public ResponseEntity<DeliveryPersonResponseDto> registerDeliveryPerson(@RequestBody DeliveryPersonRequestDto deliveryPersonRequestDto){
		deliveryService.registerDeliveryPerson(deliveryPersonRequestDto);
		return null;
	}

}
