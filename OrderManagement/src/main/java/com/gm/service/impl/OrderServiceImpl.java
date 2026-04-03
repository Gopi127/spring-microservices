package com.gm.service.impl;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gm.builder.OrderBuilder;
import com.gm.builder.OrderDtoBuilder;
import com.gm.dao.OrderRepository;
import com.gm.dto.OrderRequestDto;
import com.gm.dto.OrderResponseDto;
import com.gm.exceptions.OrderNotFound;
import com.gm.model.Order;
import com.gm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	public final OrderRepository orderRepository;
	
	public final RestTemplate restTemplate;
	
	public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
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
		String restaurantName = restTemplate.getForObject("http://localhost:8003/restaurants/name/" + order.getRestaurantId(), String.class);
		return restaurantName;
	}
}
