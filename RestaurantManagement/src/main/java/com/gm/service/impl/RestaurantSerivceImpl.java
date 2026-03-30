package com.gm.service.impl;

import org.springframework.stereotype.Service;

import com.gm.builder.RestaurantBuilder;
import com.gm.dao.RestaurantRepository;
import com.gm.dto.RestaurantCreationResponse;
import com.gm.dto.RestaurantRequestDto;
import com.gm.model.Restaurant;
import com.gm.service.RestaurantService;

@Service
public class RestaurantSerivceImpl implements RestaurantService {
	
	public final RestaurantRepository restaurantRepository;
	
	public RestaurantSerivceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public RestaurantCreationResponse addRestaurant(RestaurantRequestDto restaurantRequestDto) {
		
		Restaurant restaurant = RestaurantBuilder.buildRestaurantFromRestaurantDto(restaurantRequestDto);
		
		Restaurant savedRestaurant = restaurantRepository.save(restaurant); 
		
		return new RestaurantCreationResponse(savedRestaurant.getRestaurantId(), savedRestaurant.getRestaurantName());
	}

}
