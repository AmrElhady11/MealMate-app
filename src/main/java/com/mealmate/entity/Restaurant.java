package com.mealmate.entity;

import com.mealmate.enums.RestaurantStatus;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private RestaurantStatus status;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;





}
