package com.gm.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.RestaurantCreationResponse;
import com.gm.dto.RestaurantRequestDto;
import com.gm.dto.RestaurantResponseDto;
import com.gm.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	public final RestaurantService restaurantService;
	
	@Autowired
	public Environment environment;
	
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/add")
	public ResponseEntity<RestaurantCreationResponse> addRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
		RestaurantCreationResponse restaurantCreationResponse = restaurantService.addRestaurant(restaurantRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantCreationResponse);
	}
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable( name = "restaurantId" ) long id) {
		RestaurantResponseDto restaurantResponseDto = restaurantService.getRestaurantById(id);
		return ResponseEntity.status(HttpStatus.OK).body(restaurantResponseDto);
	}
	
	@GetMapping("/name/{restaurantId}")
	public ResponseEntity<String> getRestaurantNameById(@PathVariable( name = "restaurantId" ) long id) {
		RestaurantResponseDto restaurantResponseDto = restaurantService.getRestaurantById(id);
		@Nullable
		String port = environment.getProperty("local.server.port");
		return ResponseEntity.status(HttpStatus.OK).body(restaurantResponseDto.getRestaurantName() + port);
	}
}

