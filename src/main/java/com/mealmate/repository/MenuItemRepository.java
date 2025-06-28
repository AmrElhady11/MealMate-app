package com.mealmate.repository;

import com.mealmate.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    void deleteMenuItemByMenuId(Long menuId);
    List<MenuItem> findMenuItemByMenuId(Long menuId);
}
