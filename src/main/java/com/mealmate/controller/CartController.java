package com.mealmate.controller;

import com.mealmate.repository.CartRepository;
import com.mealmate.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
private final CartService cartService;







}
