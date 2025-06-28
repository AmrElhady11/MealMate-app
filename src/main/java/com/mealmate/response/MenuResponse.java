package com.mealmate.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuResponse {
    private Long id;
    private String name;
    private String description;
    private Long restaurantId;
    private String createdBy;
    private String updatedBy;
}
