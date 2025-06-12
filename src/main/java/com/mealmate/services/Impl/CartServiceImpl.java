package com.mealmate.services.Impl;

import com.mealmate.entity.Cart;
import com.mealmate.entity.CartItem;
import com.mealmate.exception.NotFoundException;
import com.mealmate.repository.CartItemRepository;
import com.mealmate.repository.CartRepository;
import com.mealmate.request.CartItemRequest;
import com.mealmate.services.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public Cart addItemToCart(CartItemRequest cartItemRequest) {
        var cart = cartRepository.findById(cartItemRequest.getCartId()).orElseThrow(()-> new NotFoundException(String.format("The cart with id : %d is not exist", cartItemRequest.getCartId())));
        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .unitPrice(cartItemRequest.getUnitPrice())
                .id(cartItemRequest.getCartId())
                .quantity(cartItemRequest.getQuantity())
                .build();
        // we will calculate the total price for item
        // save cart item

        return null;
    }


}
