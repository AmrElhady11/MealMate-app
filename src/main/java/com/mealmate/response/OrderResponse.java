package com.mealmate.response;

import com.mealmate.entity.CartItem;
import com.mealmate.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long customerId;
    private Long restaurantId;
    private List<CartItem> items;
    private Double totalPrice;
    private LocalDateTime orderTime;
    private String orderAddress;
    private OrderStatus orderStatus;
}
