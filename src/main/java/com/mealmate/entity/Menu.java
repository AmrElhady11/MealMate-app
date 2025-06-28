package com.mealmate.entity;

import com.mealmate.request.MenuRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
@EqualsAndHashCode(callSuper = false)
public class Menu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

public static Menu buildMenu(MenuRequest request){
    Menu menu = Menu.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .build();
    menu.setCreatedBy(request.getCreatedBy());
    menu.setUpdatedBy(request.getUpdatedBy());
    return menu;

}

}
