package com.mealmate.controller;

import com.mealmate.enums.CartStatus;
import com.mealmate.request.CartItemRequest;
import com.mealmate.request.CartRequest;
import com.mealmate.response.CartItemResponse;
import com.mealmate.response.CartResponse;
import com.mealmate.services.CartService;
import com.mealmate.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
private final CartService cartService;
private final MapperUtil mapperUtil;
    private final ModelMapper modelMapper;

    @PostMapping("/add/cartItem")
ResponseEntity<CartResponse> addCartItem(@RequestBody  CartItemRequest request) {
    CartResponse cartResponse = mapperUtil.map(cartService.addItemToCart(request), CartResponse.class);
    return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);

}
    @PostMapping("")
    ResponseEntity<CartResponse> createCart(@RequestBody CartRequest request) {
    CartResponse cartResponse = mapperUtil.map(cartService.createCart(request), CartResponse.class);
    return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);

    }
    @PatchMapping("")
    ResponseEntity<CartItemResponse> updateCartItem(@RequestBody CartItemRequest request) {
    var cartItemResponse = mapperUtil.map(cartService.updateCartItem(request), CartItemResponse.class);
    return new ResponseEntity<>(cartItemResponse, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/cartItem/{itemId}")
    ResponseEntity<String> deleteCartItem(@PathVariable Long itemId) {
    cartService.removeItemFromCart(itemId);
    return  ResponseEntity.ok(String.format("cart item with id : %d is removed successfully",itemId));
    }


    @DeleteMapping("/clear/{cartId}")
    ResponseEntity<String> clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
        return  ResponseEntity.ok(String.format("all items in cart with id : %d is removed successfully",cartId));
    }

    @GetMapping("/{cartId}")
    ResponseEntity<List<CartItemResponse>> browsCart(@PathVariable Long cartId) {
    var response = mapperUtil.map(cartService.browseCart(cartId), CartItemResponse.class);
    return new ResponseEntity<>(response, HttpStatus.FOUND);

    }



    @GetMapping("/status/{cartId}")
    ResponseEntity<CartStatus> getCartStatus(@PathVariable Long cartId) {
        var cart = cartService.getCartStatus(cartId);
        return new ResponseEntity<>(cart.getStatus(), HttpStatus.FOUND);

    }
    @PutMapping("/status")
    ResponseEntity<CartStatus> UpdateCartStatus(@RequestParam Long cartId,@RequestParam CartStatus newStatus) {
        var cart = cartService.getCartStatus(cartId);
        cart.setStatus(newStatus);
        return new ResponseEntity<>(cart.getStatus(), HttpStatus.FOUND);

    }
    @PostMapping("/item-availability")
    public ResponseEntity<String> checkItemAvailability(@RequestParam Long itemId) {
        var item =cartService.checkItemAvailability(itemId);
        return ResponseEntity.ok(String.format("cart item with id : %d is available.",item.getId()));

    }




}
