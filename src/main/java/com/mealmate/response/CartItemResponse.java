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
    private Long id;
    private Long MenuItemId;
    private Integer quantity;
    private Double UnitPrice;

}
