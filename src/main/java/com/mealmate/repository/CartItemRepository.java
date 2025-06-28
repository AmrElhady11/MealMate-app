package com.mealmate.repository;

import com.mealmate.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteByCartId(Long cartId);
    List<CartItem> findAllByCartId(Long cartId);
}
