package com.mealmate.services.Impl;

import com.mealmate.entity.Cart;
import com.mealmate.repository.CartRepository;
import com.mealmate.request.CartItemRequest;
import com.mealmate.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart addItemToCart(CartItemRequest cartItemRequest) {
        var cart = cartRepository.findById(cartItemRequest.getCartId()).orElseThrow()
        return null;
    }


}
