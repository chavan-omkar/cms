package com.dac.canteen_management_system.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDetailsResponse {
    private long userId;
    private String orderId;
    private double amount;
}
