package com.mealmate.entity;

import com.mealmate.request.CartItemRequest;
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
    private Double unitPrice;
    @Column(name = "total_price",insertable=false , updatable=false)
    private Double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne(cascade = CascadeType.ALL)
    private MenuItem menuItem;
    public Double getTotalPrice() {
        return totalPrice != null ? totalPrice : 0.0;
    }


    public static CartItem buildCartItem( CartItemRequest request) {
       return CartItem.builder()
                .unitPrice(request.getUnitPrice())
                .id(request.getId())
                .quantity(request.getQuantity())
                .build();

    }
}
