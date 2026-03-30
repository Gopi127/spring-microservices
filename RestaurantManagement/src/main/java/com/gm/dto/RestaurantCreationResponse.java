package com.gm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantCreationResponse {

	private long restaurantId;
	
	private String restaurantName;
}
