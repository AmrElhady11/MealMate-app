package com.mealmate.controller;

import com.mealmate.request.MenuItemRequest;
import com.mealmate.request.MenuRequest;
import com.mealmate.response.MenuItemResponse;
import com.mealmate.response.MenuResponse;
import com.mealmate.services.MenuService;
import com.mealmate.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/menus")
public class MenuController {

    private final MenuService menuService;
    private final MapperUtil mapperUtil;

    @PostMapping("/create")
    public ResponseEntity<MenuResponse> addMenu(@RequestBody MenuRequest request) {
        MenuResponse menuResponse = mapperUtil.map(menuService.addMenu(request), MenuResponse.class);
        return new ResponseEntity<>(menuResponse, HttpStatus.CREATED);

    }

    @PostMapping("/create/item")
    public ResponseEntity<MenuItemResponse> addMenuItem(@RequestBody MenuItemRequest request) {
        MenuItemResponse menuItemResponse = mapperUtil.map(menuService.addMenuItem(request), MenuItemResponse.class);
        return new ResponseEntity<>(menuItemResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/update/item")
    public ResponseEntity<MenuItemResponse> updateMenuItem(@RequestBody MenuItemRequest request) {
        MenuItemResponse menuItemResponse = mapperUtil.map(menuService.updateMenuItem(request), MenuItemResponse.class);
        return new ResponseEntity<>(menuItemResponse, HttpStatus.ACCEPTED);
    }
     @GetMapping("/listItems/{menuId}")
    public ResponseEntity<List<MenuItemResponse>> getMenuItems(@PathVariable("menuId") long menuId) {
        List<MenuItemResponse> menuItemResponseList = mapperUtil.map(menuService.browseMenu(menuId),MenuItemResponse.class);
        return new ResponseEntity<>(menuItemResponseList, HttpStatus.FOUND);
     }


     @GetMapping("/listMenus/{restaurantId}")
    public ResponseEntity<List<MenuResponse>> getMenus(@PathVariable long restaurantId) {
        List<MenuResponse> menuResponseList = mapperUtil.map(menuService.browseMenu(restaurantId),MenuResponse.class);
        return new ResponseEntity<>(menuResponseList, HttpStatus.FOUND);
     }


     @DeleteMapping("/delete/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable long menuId) {
        menuService.deleteMenu(menuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
    @DeleteMapping("clear/{menuId}")
    public ResponseEntity<String> clearMenu(@PathVariable long menuId) {
        menuService.clearMenu(menuId);
        String status = String.format("menu with id : %d is deleted successfully",menuId);
        return new ResponseEntity<>(status,OK);
    }



    @DeleteMapping("/delete/item/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable long menuItemId) {
        menuService.deleteMenuItem(menuItemId);
        String status = String.format("menuItem with id : %d is deleted successfully",menuItemId);
        return new ResponseEntity<>(status,OK);

    }
    @GetMapping("/search/{title}")
    public ResponseEntity<List<MenuItemResponse>> searchMenuItem(@PathVariable String title) {
        List<MenuItemResponse> menuItemListResponse = mapperUtil.map(menuService.getMenuItemByTitle(title),MenuItemResponse.class);
       return new ResponseEntity<>(menuItemListResponse, FOUND);

        }


}
