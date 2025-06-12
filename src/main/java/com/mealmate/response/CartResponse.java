package com.mealmate.response;

import com.mealmate.entity.CartItem;
import com.mealmate.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {
    private Long cartId;
    private Double totalPrice;
    private List<CartItemResponse> cartItems;
    @Builder.Default
    private CartStatus status = CartStatus.READ_WRITE;

}
