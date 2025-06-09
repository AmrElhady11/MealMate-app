package com.mealmate.entity;

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
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private Double totalPrice;
//    @OneToOne(cascade = CascadeType.ALL)     //it will be added after implementing security
//    private User user
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
//    @OneToOne(cascade = CascadeType.ALL)/  /it will be added after implementing order class
//    private List<Order> orders;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;


    @Enumerated(EnumType.STRING)
    private Integer status;

    private double discount;

}
