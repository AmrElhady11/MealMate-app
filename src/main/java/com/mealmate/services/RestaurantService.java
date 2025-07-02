package com.mealmate.services;

import com.mealmate.entity.Restaurant;
import com.mealmate.enums.OrderStatus;
import com.mealmate.request.OrderRequest;
import com.mealmate.request.RestaurantRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface RestaurantService {

   Restaurant addRestaurant(RestaurantRequest restaurantRequest);
   Restaurant updateRestaurant(RestaurantRequest restaurantRequest);
   Page<Restaurant> getAllRestaurants(Pageable pageable);
   void deleteRestaurant(long restaurantId);
}
