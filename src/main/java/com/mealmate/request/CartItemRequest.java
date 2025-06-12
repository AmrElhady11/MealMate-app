package com.mealmate.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemRequest {
    private Long id;
    private Long menuItemId;
    private Long cartId;
    private Integer quantity;
    private Double unitPrice;

}
