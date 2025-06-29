package com.mealmate.services;

import com.mealmate.entity.Menu;
import com.mealmate.entity.MenuItem;
import com.mealmate.request.MenuItemRequest;
import com.mealmate.request.MenuRequest;

import java.util.List;

public interface MenuService {

    Menu addMenu(MenuRequest menuRequest);
    MenuItem addMenuItem(MenuItemRequest menuItemRequest);
    MenuItem updateMenuItem(MenuItemRequest menuItemRequest);
    void deleteMenu(Long menuId);
    void clearMenu(Long manuId);
    void deleteMenuItem(Long menuItemId);
    List<MenuItem> browseMenu(Long menuId);
    List<Menu> browseAllRestaurantMenus(Long restaurantId);
    List<MenuItem> getMenuItemByTitle(String title);

}
