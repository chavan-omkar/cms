package com.dac.canteen_management_system.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class OrderDetailsRequest {
    private long userId;
    private String orderId;
    private Map<Integer, Integer> orderDetails;
}
