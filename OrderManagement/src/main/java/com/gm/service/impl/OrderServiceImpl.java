package com.gm.service.impl;

import org.springframework.stereotype.Service;

import com.gm.builder.OrderBuilder;
import com.gm.builder.OrderDtoBuilder;
import com.gm.dao.OrderRepository;
import com.gm.dto.OrderRequestDto;
import com.gm.dto.OrderResponseDto;
import com.gm.model.Order;
import com.gm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	public final OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
		
		Order order = OrderBuilder.buildOrderFromOrderDTO(orderRequestDto);
		
		Order savedOrder = orderRepository.save(order);
		return OrderDtoBuilder.buildOrderResponseFromOrder(savedOrder);
	}

}
