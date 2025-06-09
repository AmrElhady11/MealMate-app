package com.mealmate.entity;

import com.mealmate.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

//    @ManyToOne
//    @JoinColumn("order_id")
//    private Order order;



}
