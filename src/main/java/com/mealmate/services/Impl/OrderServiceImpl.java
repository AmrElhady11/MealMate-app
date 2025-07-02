package com.mealmate.services.Impl;

import com.mealmate.entity.*;
import com.mealmate.enums.OrderStatus;
import com.mealmate.exception.InvalidException;
import com.mealmate.exception.NotFoundException;
import com.mealmate.repository.*;
import com.mealmate.request.OrderRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;
import com.mealmate.services.OrderService;
import com.mealmate.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderItemRepository orderItemRepository;
    private final MapperUtil mapperUtil;
    private final LocalDateTime dateTime = LocalDateTime.now();

    @Transactional
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        isOrderExist(orderRequest.getId());
        Restaurant restaurant = restaurantRepository.findById(orderRequest.getRestaurantId()).get();
        Cart cart = cartRepository.findById(orderRequest.getCartId())
                .orElseThrow(() -> new NotFoundException(String.format("Cart not found for restaurant %s", orderRequest.getRestaurantId())));

        Order order = Order.orderBuilder(orderRequest);
        return null;

    }


    @Transactional
    @Override
    public OrderResponse getOrder(OrderRequest orderRequest) {
        Order order = getOrderById(orderRequest.getId());
        return mapperUtil.map(order,OrderResponse.class);
    }

    @Override
    public OrderStatus cancelOrder(long OrderId) {
        return null;
    }

    @Override
    public OrderStatusResponse UpdateStatus(long OrderId) {
        Order order = getOrderById(OrderId);
        return mapperUtil.map(order,OrderStatusResponse.class);


    }

    @Override
    public OrderStatusResponse getStatus(long OrderId) {
        Order order = getOrderById(OrderId);
        return null;
    }

    private Order getOrderById(long OrderId) {
        return orderRepository.findById(OrderId)
                .orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", OrderId)));

    }
    private void isOrderExist(long OrderId) {
        if (orderRepository.existsById(OrderId)) {
            throw new InvalidException(String.format("Order with id %s already exists", OrderId));
        }
    }
    private List<OrderItem> getOrderItems(long OrderId) {
        return List.of();
    }

}
