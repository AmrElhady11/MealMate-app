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
    private Integer id;
    private Integer menuItemId;
    private Integer cartId;
    private Integer quantity;
    private Double unitPrice;

}
