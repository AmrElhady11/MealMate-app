package com.mealmate.services;

import com.mealmate.entity.Restaurant;
import com.mealmate.enums.OrderStatus;
import com.mealmate.request.OrderRequest;
import com.mealmate.request.RestaurantRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;

import java.awt.print.Pageable;
import java.util.List;


public interface RestaurantService {

   Restaurant addRestaurant(RestaurantRequest restaurantRequest);
   Restaurant updateRestaurant(RestaurantRequest restaurantRequest);
   List<Restaurant> getAllRestaurants(Pageable pageable);
   void deleteRestaurant(long restaurantId);
}
