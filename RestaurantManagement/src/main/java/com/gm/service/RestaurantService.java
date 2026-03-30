package com.gm.service;

import com.gm.dto.RestaurantCreationResponse;
import com.gm.dto.RestaurantRequestDto;

public interface RestaurantService {

	RestaurantCreationResponse addRestaurant(RestaurantRequestDto restaurantRequestDto);

}
