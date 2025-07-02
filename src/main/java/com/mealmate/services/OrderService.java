package com.mealmate.services;

import com.mealmate.enums.OrderStatus;

import com.mealmate.request.OrderRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;


public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(long orderId);
    void cancelOrder(long OrderId);
    OrderStatusResponse updateStatus(long OrderIdm, OrderStatus status);
    OrderStatusResponse getStatus(long OrderId);

}
