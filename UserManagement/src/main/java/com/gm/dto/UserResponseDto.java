package com.gm.dto;

import java.util.List;

import com.gm.model.UserAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	
	private long userId;
	
	private String userName;
	
	private String email;
	
	private String phoneNum;
	
	private List<UserAddress> userAddress;

}
