package com.mealmate.entity;

import com.mealmate.request.MenuItemRequest;
import jakarta.persistence.*;
import lombok.*;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_item")
@EqualsAndHashCode(callSuper = false)
public class MenuItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public static MenuItem itemBuilder(MenuItemRequest menuRequest) {
        MenuItem menuItem = MenuItem.builder()
                .description(menuRequest.getDescription())
                .title(menuRequest.getTitle())
                .price(menuRequest.getPrice())
                .quantity(menuRequest.getQuantity())
                .build();
        menuItem.setCreatedBy(menuItem.getCreatedBy());
        menuItem.setUpdatedBy(menuItem.getUpdatedBy());
        return menuItem;
    }
}
