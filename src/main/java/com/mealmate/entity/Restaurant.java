package com.mealmate.entity;

import com.mealmate.enums.RestaurantStatus;
import com.mealmate.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

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

    @Column(name = "restaurant_status")
    @Enumerated(EnumType.STRING)
    private RestaurantStatus restaurantStatus;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Column(name = "closing_time")
    private LocalTime closingTime;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private List<Address> addresses;




    public Restaurant() {
        if(LocalTime.now().isAfter(openingTime)&&LocalTime.now().isBefore(closingTime)) {
            this.restaurantStatus = RestaurantStatus.OPENED;
            // will be updated or removed when static builder method will be implemented
        }
        else
            this.restaurantStatus = RestaurantStatus.CLOSED;
    }
}
