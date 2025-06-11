package com.mealmate.repository;

import com.mealmate.entity.Cart;
import com.mealmate.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
