package com.mealmate.repository;

import com.mealmate.entity.CartItem;
import com.mealmate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
