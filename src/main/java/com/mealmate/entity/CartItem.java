package com.mealmate.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_item")
@EqualsAndHashCode(callSuper = false)
public class CartItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @Column(name = "unit_price")  //we need to update it to call its value from menu
    private Integer unitPrice;
    @Column(name = "total_price",insertable=false , updatable=false)
    private Double totalPrice;


    public Double getTotalPrice() {
        return totalPrice != null ? totalPrice : 0.0;
    }
}
