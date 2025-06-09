package com.mealmate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

//    @ManyToOne
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;



}
