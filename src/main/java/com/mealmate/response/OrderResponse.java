package com.mealmate.response;

import com.mealmate.entity.CartItem;
import com.mealmate.entity.OrderItem;
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
    private Long id;
//    private Long customerId;
    private List<OrderItem> orderItems;
    private Double totalPrice;
//    private LocalDateTime orderTime;
    private String deliveryAddress;
    private OrderStatus status;
}
