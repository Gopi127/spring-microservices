package com.gm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "RestaurantManagement")
public interface RestaurantClient {

	@GetMapping("/restaurants/name/{restaurantId}")
	public ResponseEntity<String> getRestaurantNameById(@PathVariable( name = "restaurantId" ) long id);
}
