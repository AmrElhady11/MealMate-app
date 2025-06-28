package com.mealmate.entity;

import com.mealmate.enums.CartStatus;
import com.mealmate.request.CartRequest;
import com.mealmate.response.CartResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
@EqualsAndHashCode(callSuper = false)
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "total_items")   // we need to update it to make it driven
    private Integer totalItems;

    @Enumerated(EnumType.STRING)
    private CartStatus status;
    private double discount;
    @OneToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy ="cart",cascade = CascadeType.ALL)
    private List<CartItem> cartItems;


    public static Cart createCart(CartRequest request) {
        return Cart.builder()
                .status(request.getStatus())
                .totalItems(request.getTotalItems())
                .discount(request.getDiscount())
                .totalPrice(request.getTotalPrice())
                .build();

    }

}
