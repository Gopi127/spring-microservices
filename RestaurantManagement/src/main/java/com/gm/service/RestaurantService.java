package com.gm.service;

import com.gm.dto.RestaurantCreationResponse;
import com.gm.dto.RestaurantRequestDto;
import com.gm.dto.RestaurantResponseDto;

public interface RestaurantService {

	RestaurantCreationResponse addRestaurant(RestaurantRequestDto restaurantRequestDto);

	RestaurantResponseDto getRestaurantById(long id);

}
