package com.mealmate.controller;

import com.mealmate.request.CartItemRequest;
import com.mealmate.response.CartResponse
import com.mealmate.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
private final CartService cartService;

@PostMapping("/add/cartItem")
ResponseEntity<CartResponse> addCartItem(@RequestBody CartItemRequest request) {


}







}
