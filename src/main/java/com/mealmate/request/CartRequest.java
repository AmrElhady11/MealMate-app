package com.mealmate.request;

import com.mealmate.enums.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long id;
    private Long CustomerId;
    private Double totalPrice;
    private Integer totalItems ;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private CartStatus status;
    private Double discount ;
    private String createdBy;
    private String updatedBy;
}
