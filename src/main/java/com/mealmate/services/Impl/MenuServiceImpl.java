package com.mealmate.services.Impl;

import com.mealmate.entity.Menu;
import com.mealmate.entity.MenuItem;
import com.mealmate.entity.Restaurant;
import com.mealmate.exception.NotFoundException;
import com.mealmate.repository.MenuItemRepository;
import com.mealmate.repository.MenuRepository;
import com.mealmate.repository.RestaurantRepository;
import com.mealmate.request.MenuItemRequest;
import com.mealmate.request.MenuRequest;
import com.mealmate.services.MenuService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

   private final MenuRepository menuRepository;
   private final MenuItemRepository menuItemRepository;
   private final RestaurantRepository restaurantRepository;
   private final LocalDateTime dateTime = LocalDateTime.now();

   @Transactional
   @Override
    public Menu addMenu(MenuRequest menuRequest) {
       isMenuExist(menuRequest.getId());
       Menu newMenu = Menu.buildMenu(menuRequest);
       Restaurant restaurant = restaurantRepository.findById(menuRequest.getRestaurantId())
               .orElseThrow(() -> new NotFoundException(String.format("Restaurant with id %s not found", menuRequest.getRestaurantId())));
       newMenu.setCreationTime(dateTime);
       newMenu.setRestaurant(restaurant);
        return menuRepository.save(newMenu);
    }
    @Transactional
    @Override
    public MenuItem addMenuItem(MenuItemRequest menuRequest) {
       isMenuExist(menuRequest.getMenuId());
       MenuItem newItem = MenuItem.itemBuilder(menuRequest);
       newItem.setCreationTime(dateTime);
       newItem.setUpdatedTime(dateTime);
        return menuItemRepository.save(newItem);
    }

    @Transactional
    @Override
    public MenuItem updateMenuItem(MenuItemRequest menuItemRequest) {
       isMenuExist(menuItemRequest.getMenuId());
       MenuItem item = menuItemRepository.findById(menuItemRequest.getId())
               .orElseThrow(() -> new NotFoundException(String.format("MenuItem with id %s not found", menuItemRequest.getId())));
       item.setPrice(menuItemRequest.getPrice());
       item.setQuantity(menuItemRequest.getQuantity());
       item.setDescription(menuItemRequest.getDescription());
       item.setTitle(menuItemRequest.getTitle());
       item.setUpdatedTime(dateTime);
        return menuItemRepository.save(item);
    }
    @Transactional
    @Override
    public void deleteMenu(Long manuId) {
       clearMenu(manuId);
       Menu menu = menuRepository.findById(manuId).orElseThrow(() -> new NotFoundException(String.format("Menu with id %s not found", manuId)));
    menuRepository.delete(menu);
    }

    @Override
    public void clearMenu(Long manuId) {
        Menu menu = menuRepository.findById(manuId)
                .orElseThrow(() -> new NotFoundException(String.format("Menu with id %s not found", manuId)));
        menuItemRepository.deleteMenuItemByMenuId(manuId);


    }
    @Transactional
    @Override
    public void deleteMenuItem(Long menuItemId) {
       MenuItem menuItem = menuItemRepository.findById(menuItemId)
               .orElseThrow(() -> new NotFoundException(String.format("MenuItem with id %s not found", menuItemId)));
       menuItemRepository.delete(menuItem);

    }

    @Override
    public List<MenuItem> browseMenu(Long menuId) {
       Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new NotFoundException(String.format("Menu with id %s not found", menuId)));
        return menuItemRepository.findMenuItemByMenuId(menuId);
    }

    @Override
    public List<Menu> browseAllRestaurantMenus(Long restaurantId) {
       restaurantRepository.findById(restaurantId).orElseThrow(() -> new NotFoundException(String.format("Restaurant with id %s not found", restaurantId)));
        return menuRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<MenuItem> getMenuItemByTitle(String title) {
        return List.of();
    }
    public void isMenuExist(Long menuId) {
       menuRepository.findById(menuId).orElseThrow(
               () -> new NotFoundException(String.format("Menu with id %s not found", menuId)));
    }
}
