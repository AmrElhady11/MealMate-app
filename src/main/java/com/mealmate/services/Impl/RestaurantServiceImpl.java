package com.mealmate.services.Impl;

import com.mealmate.entity.Restaurant;
import com.mealmate.enums.RestaurantStatus;
import com.mealmate.exception.InvalidException;
import com.mealmate.exception.NotFoundException;
import com.mealmate.repository.RestaurantRepository;
import com.mealmate.request.RestaurantRequest;
import com.mealmate.services.RestaurantService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {
   private final RestaurantRepository restaurantRepository;
   private final LocalDateTime dateTime = LocalDateTime.now();


   @Transactional
   @Override
   public Restaurant addRestaurant(RestaurantRequest restaurantRequest) {
      Restaurant restaurant = Restaurant.restaurantBuilder(restaurantRequest);
      restaurant.setCreationTime(dateTime);
     return restaurantRepository.save(restaurant);

   }

   @Transactional
   @Override
   public Restaurant updateRestaurant(RestaurantRequest restaurantRequest) {
      isRestaurantNotExist(restaurantRequest.getId());
      Restaurant restaurant = restaurantRepository.findById(restaurantRequest.getId()).get();
      restaurant.setName(restaurantRequest.getName());
      restaurant.setDescription(restaurantRequest.getDescription());
      restaurant.setAddress(restaurantRequest.getAddress());
      restaurant.setRestaurantStatus(restaurantRequest.getStatus());
      restaurant.setUpdatedTime(dateTime);
      return restaurantRepository.save(restaurant);
   }

   @Override
   public List<Restaurant> getAllRestaurants(Pageable pageable) {
      return (List<Restaurant>) restaurantRepository.findAll(pageable);
   }
   @Transactional
   @Override
   public void deleteRestaurant(long restaurantId) {
      Restaurant restaurant = restaurantRepository.findById(restaurantId)
              .orElseThrow(()-> new NotFoundException(String.format("Restaurant with id %s not found", restaurantId)));
      restaurantRepository.delete(restaurant);


   }

   private void isRestaurantExist(long restaurantId) {
      if (restaurantRepository.findById(restaurantId).isPresent()) {
         throw new InvalidException(String.format("Restaurant with id %s already exists", restaurantId));
      }
   }

      private void isRestaurantNotExist(long restaurantId) {
        restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException(String.format("Restaurant with id %s does not exist", restaurantId)));

   }
}
