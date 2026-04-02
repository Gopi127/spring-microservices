package com.gm.builder;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.web.client.RestTemplate;

import com.gm.dto.OrderItemResponseDto;
import com.gm.dto.OrderResponseDto;
import com.gm.model.Order;
import com.gm.model.OrderItem;


public class OrderDtoBuilder {
	
	public final RestTemplate restTemplate;
	
	public OrderDtoBuilder(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public OrderDtoBuilder() {
		this.restTemplate = new RestTemplate();
	}
	

	public static OrderResponseDto buildOrderResponseFromOrder(Order order) {
		OrderDtoBuilder orderDtoBuilder = new OrderDtoBuilder();
		return OrderResponseDto.builder()
						.status(order.getStatus())
						.orderPrice(order.getOrderPrice())
						.orderItems(buildOrderItemResponseDtos(order.getOrderItems()))
						.restaurantName(orderDtoBuilder.fetchRestaurantName(order.getRestaurantId()))
						.build();
	}
	
	private static List<OrderItemResponseDto> buildOrderItemResponseDtos(List<OrderItem> orderItemList){
		
		List<OrderItemResponseDto> orderItemResponseList = new ArrayList<>();
		
		for(OrderItem orderItem: orderItemList) {
			OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
			BeanUtils.copyProperties(orderItem, orderItemResponseDto);
			orderItemResponseList.add(orderItemResponseDto);
		}
		
		return orderItemResponseList;
	}
	
	private String fetchRestaurantName(long restaurantId) {
		@Nullable
		String name = restTemplate.getForObject("http://localhost:8003/restaurants/name/" + restaurantId, String.class);
		return name;
	}
}
