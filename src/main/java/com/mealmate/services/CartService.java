package com.mealmate.services;

import com.mealmate.entity.Cart;
import com.mealmate.entity.CartItem;
import com.mealmate.entity.MenuItem;
import com.mealmate.enums.CartStatus;
import com.mealmate.request.CartItemRequest;
import com.mealmate.request.CartRequest;

import java.util.List;

public interface CartService {
    Cart addItemToCart(CartItemRequest cartItemRequest);
    void removeItemFromCart(Long cartItemId);
    void clearCart(Long cartId);
    CartItem updateCartItem(CartItemRequest cartItemRequest);
    List<CartItem> browseCart(Long cartId);
    Cart getCartStatus(Long cartId);
    Cart updateCartStatus(Long cartId, CartStatus newCartStatus);
    MenuItem checkItemAvailability(Long itemId);
    Cart createCart(CartRequest cartRequest);
}
