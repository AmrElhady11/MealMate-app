package com.mealmate.repository;

import com.mealmate.entity.CartItem;
import com.mealmate.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByRestaurantId(Long restaurantId);
}
