package com.gm.service.impl;

import org.springframework.stereotype.Service;

import com.gm.dto.DeliveryPersonRequestDto;
import com.gm.dto.DeliveryPersonResponseDto;
import com.gm.model.DeliveryPerson;
import com.gm.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Override
	public DeliveryPersonResponseDto registerDeliveryPerson(DeliveryPersonRequestDto deliveryPersonRequestDto) {
		
		DeliveryPerson deliveryPerson = new DeliveryPerson();
		
		deliveryPerson.setAadharNum(deliveryPersonRequestDto.getAadharNum());
		deliveryPerson.setPhoneNum(deliveryPersonRequestDto.getPhoneNum());
		deliveryPerson.setEmail(deliveryPersonRequestDto.getEmail());
		deliveryPerson.setAvailable(deliveryPersonRequestDto.isAvailable());
		deliveryPerson.setRating(deliveryPersonRequestDto.getRating());
		
		return null;
	}

}
