package com.mealmate.response;

import com.mealmate.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusResponse {
    private Long OrderId;
    private OrderStatus status;
}
