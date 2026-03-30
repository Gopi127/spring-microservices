package com.gm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.RestaurantCreationResponse;
import com.gm.dto.RestaurantRequestDto;
import com.gm.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	public final RestaurantService restaurantSerivce;
	
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantSerivce = restaurantService;
	}

	@PostMapping("/add")
	public ResponseEntity<RestaurantCreationResponse> addRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
		RestaurantCreationResponse restaurantCreationResponse = restaurantSerivce.addRestaurant(restaurantRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantCreationResponse);
	}
}
