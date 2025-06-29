package com.mealmate.entity;

import com.mealmate.enums.RestaurantStatus;
import com.mealmate.enums.Status;
import com.mealmate.request.RestaurantRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;

    @Column(name = "restaurant_status")
    @Enumerated(EnumType.STRING)
    private RestaurantStatus restaurantStatus;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Column(name = "closing_time")
    private LocalTime closingTime;








    public static  Restaurant restaurantBuilder(RestaurantRequest restaurantRequest){
        Restaurant restaurant = Restaurant.builder()
                .id(restaurantRequest.getId())
                .restaurantStatus(restaurantRequest.getStatus())
                .description(restaurantRequest.getDescription())
                .address(restaurantRequest.getAddress())
                .openingTime(restaurantRequest.getOpeningTime())
                .closingTime(restaurantRequest.getClosingTime())
                .build();
        restaurant.setCreatedBy(restaurantRequest.getCreatedBy());
        restaurantRequest.setUpdatedBy(restaurantRequest.getUpdatedBy());
        return restaurant;
    }
}
