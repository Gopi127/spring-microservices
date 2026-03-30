package com.gm.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAssignmentResponseDto {
	
	private long deliveryAssignmentId;
	
	private String status;
	
	private long orderId;
	
	private LocalTime assignedTime;
	
	private String deliveryPersonName;
	
	private String deliveryPersonId;

}
