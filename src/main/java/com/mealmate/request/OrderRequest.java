package com.mealmate.request;

import com.mealmate.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long CartId;
    private Long CustomerId;
    private Long restaurantId;
    private List<CartItem> items;
    private String deliveryAddress;
}
