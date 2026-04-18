package com.gm.service;

import org.springframework.http.ResponseEntity;

import com.gm.dto.OrderRequestDto;
import com.gm.dto.OrderResponseDto;

public interface OrderService {

	OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

	OrderResponseDto updateOrderStatus(long orderId, String status);

	ResponseEntity<String> getRestaurantName(long restaurantId);

	String getRestaurantNameById(long restaurantId);

}
