package com.mealmate.controller;

import com.mealmate.entity.Restaurant;
import com.mealmate.request.RestaurantRequest;
import com.mealmate.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantRequest request) {
        Restaurant restaurant = restaurantService.addRestaurant(request);
        return new ResponseEntity<>(restaurant,CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantRequest request) {
        Restaurant restaurant = restaurantService.updateRestaurant(request);
        return new ResponseEntity<>(restaurant,ACCEPTED);
    }
    @GetMapping("/allRestaurants")
    public ResponseEntity<Page<Restaurant>> getAllRestaurants(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = (Pageable) PageRequest.of(page,size);
        Page<Restaurant> restaurantList = restaurantService.getAllRestaurants(pageable);
        return new ResponseEntity<>(restaurantList,FOUND);
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(NO_CONTENT);

    }

}
