package com.mealmate.services;

import com.mealmate.entity.Cart;
import com.mealmate.request.CartItemRequest;

public interface CartService {
    Cart addItemToCart(CartItemRequest cartItemRequest);
}
