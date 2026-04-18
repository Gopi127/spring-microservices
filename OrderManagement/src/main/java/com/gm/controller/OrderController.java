package com.gm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.OrderRequestDto;
import com.gm.dto.OrderResponseDto;
import com.gm.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	@Autowired
	public OrderService orderService;
	
	@PostMapping("/place-order")
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
		OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
	}
	
	@PutMapping("/status/{orderId}")
	public ResponseEntity<OrderResponseDto> updateOrderStatus(@PathVariable( name = "orderId") long orderId,@RequestParam( name="status") String status) {
		OrderResponseDto orderResponseDto = orderService.updateOrderStatus(orderId, status);
		return ResponseEntity.ok(orderResponseDto);
	}
	
	@GetMapping("/restaurant-name/{id}")
	public ResponseEntity<String> getRestaurantName(@PathVariable(name = "id") long restaurantId){
		return orderService.getRestaurantName(restaurantId)
;	}
	
	@GetMapping("/restaurant/name/{restaurantId}")
	public String getRestaurantNameById(@PathVariable( name="restaurantId") long restaurantId) {
		return orderService.getRestaurantNameById(restaurantId);
	}

}
