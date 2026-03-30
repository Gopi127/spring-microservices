package com.gm.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gm.dto.AddressRequestDto;
import com.gm.dto.ItemRequestDto;
import com.gm.dto.RestaurantRequestDto;
import com.gm.model.Address;
import com.gm.model.Item;
import com.gm.model.Restaurant;

public class RestaurantBuilder {
	
	public static Restaurant buildRestaurantFromRestaurantDto(RestaurantRequestDto restaurantRequestDto) {
		return Restaurant.builder()
				  .restaurantName(restaurantRequestDto.getRestaurantName())
				  .phoneNum(restaurantRequestDto.getPhoneNum())
				  .address(buildAddressFromAddressDto(restaurantRequestDto.getAddressRequestDto()))
				  .items(buildItemFromItemDto(restaurantRequestDto.getItemRequestDtoList()))
				  .build();
				  
	}
	
	private static Address buildAddressFromAddressDto(AddressRequestDto addressRequestDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressRequestDto, address);
		
		return address;
	}
	
	private static List<Item> buildItemFromItemDto(List<ItemRequestDto> itemRequestDtos){
		
		List<Item> itemList = new ArrayList<>();
		
		for(ItemRequestDto itemRequest: itemRequestDtos) {
			Item item = new Item();
			BeanUtils.copyProperties(itemRequest, item);
			itemList.add(item);
		}
		
		return itemList;
	}

}
