package com.mealmate.repository;

import com.mealmate.entity.CartItem;
import com.mealmate.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
