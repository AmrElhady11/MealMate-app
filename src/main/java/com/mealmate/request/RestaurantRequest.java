package com.mealmate.request;

import com.mealmate.enums.RestaurantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    private Long id;
    private String name;
    private String address;
    private String description;
    private RestaurantStatus status;
    private String createdBy;
    private String updatedBy;
    private LocalTime openingTime;
    private LocalTime closingTime;

}
