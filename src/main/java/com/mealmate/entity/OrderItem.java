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
@Table(name = "order_item")
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer quantity;
    @Column(name = "unit_price")  //we need to update it to call its value from menu
    private Double unitPrice;
    @Column(name = "total_price",insertable=false , updatable=false)
    private Double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MenuItem menuItemId ;


    public static OrderItem buildOrderItem(CartItem item) {
       return OrderItem.builder()
                .unitPrice(item.getUnitPrice())
                .quantity(item.getQuantity())
                .build();

    }
}
