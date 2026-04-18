package com.gm.service.impl;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gm.builder.OrderBuilder;
import com.gm.builder.OrderDtoBuilder;
import com.gm.clients.RestaurantClient;
import com.gm.dao.OrderRepository;
import com.gm.dto.OrderRequestDto;
import com.gm.dto.OrderResponseDto;
import com.gm.exceptions.OrderNotFound;
import com.gm.model.Order;
import com.gm.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {
	
	public final OrderRepository orderRepository;
	
	public final RestTemplate restTemplate;
	
	public final RestaurantClient restaurantClient;
	
	public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate, RestaurantClient
 restaurantClient) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
		this.restaurantClient = restaurantClient;
	}

	@Override
	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
		
		Order order = OrderBuilder.buildOrderFromOrderDTO(orderRequestDto);
		
		Order savedOrder = orderRepository.save(order);
		OrderResponseDto orderResponseDto = OrderDtoBuilder.buildOrderResponseFromOrder(savedOrder);
		
		@Nullable
		String restaurantName = fetchRestaurantName(order);
		orderResponseDto.setRestaurantName(restaurantName);
		return orderResponseDto;
	}

	@Override
	public OrderResponseDto updateOrderStatus(long orderId, String status) {

		Order order = orderRepository.findById(orderId)
						.orElseThrow(() -> new OrderNotFound("No Order Found with Id: " + orderId));
		order.setStatus(status);
		
		orderRepository.save(order);
		
		String restaurantName = fetchRestaurantName(order);
		
		OrderResponseDto orderResponseDto = OrderDtoBuilder.buildOrderResponseFromOrder(order);
		orderResponseDto.setRestaurantName(restaurantName);
		
		return orderResponseDto;
		
	}
	
	private String fetchRestaurantName(Order order) {
		String restaurantName = restTemplate.getForObject("http://RestaurantManagement/restaurants/name/" + order.getRestaurantId(), String.class);
		return restaurantName;
	}

	@Override
	public ResponseEntity<String> getRestaurantName(long restaurantId) {
		return restaurantClient.getRestaurantNameById(restaurantId);
	}

	@Override
	@CircuitBreaker( name = "restaurantManagementCB", fallbackMethod = "fallBackForRestaurantName")
	public String getRestaurantNameById(long restaurantId) {
		return restTemplate.getForObject("http://RestaurantManagement/restaurants/name/" + restaurantId, String.class);

	}
	
	public String fallBackForRestaurantName(long restaurantId, Throwable throwable) {
		return "Restaurant server is down";
	}
}
