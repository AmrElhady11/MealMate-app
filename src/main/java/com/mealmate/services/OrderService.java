package com.mealmate.services;

import com.mealmate.enums.OrderStatus;

import com.mealmate.request.OrderRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;


public interface OrderService {

    OrderResponse getOrder(OrderRequest orderRequest);
    OrderStatus cancelOrder(long OrderId);
    OrderStatusResponse UpdateStatus(long OrderId);
    OrderStatusResponse getStatus(long OrderId);

}
