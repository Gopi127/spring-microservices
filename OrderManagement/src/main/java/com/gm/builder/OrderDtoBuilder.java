package com.gm.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gm.dto.OrderItemResponseDto;
import com.gm.dto.OrderResponseDto;
import com.gm.model.Order;
import com.gm.model.OrderItem;


public class OrderDtoBuilder {	

	public static OrderResponseDto buildOrderResponseFromOrder(Order order) {
		return OrderResponseDto.builder()
						.status(order.getStatus())
						.orderPrice(order.getOrderPrice())
						.orderItems(buildOrderItemResponseDtos(order.getOrderItems()))
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
}
