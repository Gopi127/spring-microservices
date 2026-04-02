package com.gm.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.gm.dto.AddressResponseDto;
import com.gm.dto.ItemResponseDto;
import com.gm.dto.RestaurantResponseDto;
import com.gm.model.Address;
import com.gm.model.Item;
import com.gm.model.Restaurant;

public class RestaurantDTOBuilder {
	
	public static RestaurantResponseDto buildRestaurantRespDtoFromRestaurant(Restaurant restaurant) {
		return RestaurantResponseDto.builder()
							 .restaurantId(restaurant.getRestaurantId())
							 .restaurantName(restaurant.getRestaurantName())
							 .phoneNum(restaurant.getPhoneNum())
							 .addressResponseDto(buildAddressRespDtoFromAddress(restaurant.getAddress()))
							 .itemResponseDtoList(buildItemRespDtoFromItem(restaurant.getItems()))
							 .build();
	}

	private static AddressResponseDto buildAddressRespDtoFromAddress(Address address) {
		AddressResponseDto addressResponseDto = new AddressResponseDto();
		BeanUtils.copyProperties(address, addressResponseDto);
		
		return addressResponseDto;
	}
	
	private static List<ItemResponseDto> buildItemRespDtoFromItem(List<Item> items) {
		List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
		for(Item item: items) {
			ItemResponseDto itemResonseDto = new ItemResponseDto();
			BeanUtils.copyProperties(item, itemResonseDto);
			itemResponseDtoList.add(itemResonseDto);
		}
		
		return itemResponseDtoList;
	}
}
