package com.mealmate.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemResponse {
    private Integer id;
    private Integer MenuItemId;
    private Integer quantity;
    private Double UnitPrice;

}
