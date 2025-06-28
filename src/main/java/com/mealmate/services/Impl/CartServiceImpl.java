package com.mealmate.services.Impl;

import com.mealmate.entity.Cart;
import com.mealmate.entity.CartItem;
import com.mealmate.entity.MenuItem;
import com.mealmate.enums.CartStatus;
import com.mealmate.exception.NotFoundException;
import com.mealmate.repository.CartItemRepository;
import com.mealmate.repository.CartRepository;
import com.mealmate.repository.CustomerRepository;
import com.mealmate.repository.MenuItemRepository;
import com.mealmate.request.CartItemRequest;
import com.mealmate.request.CartRequest;
import com.mealmate.services.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MenuItemRepository menuItemRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Cart addItemToCart(CartItemRequest cartItemRequest) {
        var cart = getCartById(cartItemRequest.getCartId());

        CartItem cartItem = CartItem.buildCartItem(cartItemRequest);
        cartItem.setCart(cart);
        cart.setCreationTime(dateTime);
        updateCartDetails(cartItem,cart);
        return cartRepository.save(cart);


    }

    @Override
    @Transactional
    public void removeItemFromCart(Long cartItemId) {
        var cartItem = getCartItemById(cartItemId);
        cartItem.getCart().setUpdatedTime(dateTime);
        cartItemRepository.delete(cartItem);
    }

    @Override
    @Transactional
    public void clearCart(Long cartId) {
        var cart = getCartById(cartId);
        cartItemRepository.deleteByCartId(cartId);
        cart.setTotalPrice(0.0);
        cart.setTotalItems(0);

    }

    @Transactional
    @Override
    public CartItem updateCartItem(CartItemRequest cartItemRequest) {
        var cart = getCartById(cartItemRequest.getCartId());
        CartItem cartItem = getCartItemById(cartItemRequest.getId()); // we change here
        cartItem.setUnitPrice(cartItemRequest.getUnitPrice());
        cartItem.setQuantity(cartItemRequest.getQuantity());
        updateCartDetails(cartItem,cart);
        cart.setUpdatedTime(dateTime);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> browseCart(Long cartId) {
        var cart = getCartById(cartId);
        return cartItemRepository.findAllByCartId(cartId);
    }

    @Override
    public Cart getCartStatus(Long cartId) {
        return getCartById(cartId);
    }

    @Transactional
    @Override
    public Cart updateCartStatus(Long cartId, CartStatus newCartStatus) {
        var cart = getCartById(cartId);
        cart.setStatus(newCartStatus);
        cart.setUpdatedTime(dateTime);
        return cartRepository.save(cart);
    }



    @Override
    public MenuItem checkItemAvailability(Long itemId) {
       return menuItemRepository.findById(itemId).orElseThrow(()->new NotFoundException(String.format("Item with id : %d not found",itemId)));
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        var customer = customerRepository.findById(cartRequest.getCustomerId()).orElseThrow(()->new NotFoundException(String.format("Customer with id : %d not found",cartRequest.getCustomerId())));
        var newCart = Cart.createCart(cartRequest);
        newCart.setCreationTime(dateTime);
        newCart.setUpdatedTime(dateTime);
        newCart.setCustomer(customer);

        return cartRepository.save(newCart);
    }



    private Cart getCartById(Long cartId){
        return cartRepository.findById(cartId).orElseThrow(()-> new NotFoundException(String.format("The cart with id : %d is not exist", cartId)));
    }
    private CartItem getCartItemById(Long cartItemId){
        return cartItemRepository.findById(cartItemId).orElseThrow(()->new NotFoundException("CartItem not found"));

    }
    private void updateCartDetails(CartItem cartItem, Cart cart){
        double oldCartItemTotalPrice = cartItem.getTotalPrice();
        int oldCartItemTotalQuantity = cartItem.getQuantity();
        cartItem.setTotalPrice(cartItem.getUnitPrice()*cartItem.getQuantity());
        calculateCartTotalPriceAndTotalItems(cartItem,cart,oldCartItemTotalPrice,oldCartItemTotalQuantity);

    }
    private void calculateCartTotalPriceAndTotalItems(CartItem cartItem,Cart cart, double oldCartItemTotalPrice, int oldCartItemTotalQuantity){
        cart.setTotalPrice(cart.getTotalPrice() - oldCartItemTotalPrice + cartItem.getTotalPrice());
        cart.setTotalItems(cart.getTotalItems() - oldCartItemTotalQuantity +cartItem.getQuantity());
    }


}
