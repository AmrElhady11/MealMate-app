package com.mealmate.entity;

import com.mealmate.enums.AddressOwnerStatus;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private AddressOwnerStatus addressOwner;
    @Column(name = "owner_id")
    private Long addressOwnerId;
}
