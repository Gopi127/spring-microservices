package com.gm.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gm.dto.OrderItemRequestDto;
import com.gm.dto.OrderRequestDto;
import com.gm.model.Order;
import com.gm.model.OrderItem;

public class OrderBuilder {
	
	public static Order buildOrderFromOrderDTO(OrderRequestDto orderRequestDto) {

		return Order.builder()
			 .status("Ordered")
			 .orderPrice(orderRequestDto.getOrderPrice())
			 .userId(orderRequestDto.getUserId())
			 .restaurantId(orderRequestDto.getRestaurantId())
			 .orderItems(buildOrderItemFromItemDTO(orderRequestDto.getOrderItems()))
			 .build();
	}
	
	private static List<OrderItem> buildOrderItemFromItemDTO(List<OrderItemRequestDto> orderItemRequestDtoList){
		
		List<OrderItem> orderItemsList = new ArrayList<>();
		
		for(OrderItemRequestDto orderItemRequest: orderItemRequestDtoList) {
			OrderItem orderItem = new OrderItem();
			BeanUtils.copyProperties(orderItemRequest, orderItem);
			orderItemsList.add(orderItem);
		}
		
		return orderItemsList;
	}

}
