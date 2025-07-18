package com.mealmate.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemResponse {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer quantity;
    private Long menuId;
}
