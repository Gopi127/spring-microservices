package com.gm.service;


import com.gm.dto.DeliveryPersonRequestDto;
import com.gm.dto.DeliveryPersonResponseDto;

public interface DeliveryService {

	DeliveryPersonResponseDto registerDeliveryPerson(DeliveryPersonRequestDto deliveryPersonRequestDto);

}
