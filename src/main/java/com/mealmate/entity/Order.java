package com.mealmate.entity;

import com.mealmate.enums.OrderStatus;
import com.mealmate.request.OrderRequest;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private Double totalPrice;
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;




public static Order orderBuilder(OrderRequest orderRequest) {
   return Order.builder()
            .id(orderRequest.getId())
            .deliveryAddress(orderRequest.getDeliveryAddress())
            .build();


}



}
