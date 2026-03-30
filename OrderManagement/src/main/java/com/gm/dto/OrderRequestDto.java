package com.gm.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
	
	private double orderPrice;
	
	private long userId;
	
	private long restaurantId;
	
	private List<OrderItemRequestDto> orderItems;

}
