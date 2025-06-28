package com.mealmate.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRequest {
    private Long id;
    private String name;
    private String description;
    private Long restaurantId;
    private String createdBy;
    private String updatedBy;
}
