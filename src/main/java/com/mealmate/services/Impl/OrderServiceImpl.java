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
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final MapperUtil mapperUtil;
    private final LocalDateTime dateTime = LocalDateTime.now();

    @Transactional
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        isOrderExist(orderRequest.getId());
        Cart cart = cartRepository.findById(orderRequest.getCartId())
                .orElseThrow(() -> new NotFoundException(String.format("Cart not found for restaurant %s", orderRequest.getRestaurantId())));
        List<CartItem> cartItems = cartItemRepository.findAllByCartId(orderRequest.getCartId());

        if(cartItems.isEmpty())
            throw new InvalidException(String.format("Your cart is empty", orderRequest.getRestaurantId()));

        List<OrderItem> orderItems = getOrderItems(cartItems);
        Order order = Order.orderBuilder(orderRequest);
        order.setOrderItems(orderItems);
        orderRepository.save(order);
        return mapperUtil.map(order, OrderResponse.class);
    }


    @Transactional
    @Override
    public OrderResponse getOrder(long orderId) {
        Order order = getOrderById(orderId);
        return mapperUtil.map(order,OrderResponse.class);
    }

    @Override
    public void cancelOrder(long OrderId) {
        orderRepository.deleteById(OrderId);
    }

    @Override
    public OrderStatusResponse updateStatus(long OrderId,OrderStatus status) {
        Order order = getOrderById(OrderId);
        order.setStatus(status);
        return mapperUtil.map(order,OrderStatusResponse.class);


    }

    @Override
    public OrderStatusResponse getStatus(long OrderId) {
        Order order = getOrderById(OrderId);
        return mapperUtil.map(order,OrderStatusResponse.class);
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
    private List<OrderItem> getOrderItems(List<CartItem> cartItems) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
          orderItems.add(OrderItem.buildOrderItem(cartItem));
        }
        return orderItems;
    }

}
