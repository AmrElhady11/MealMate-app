package com.mealmate.controller;

import com.mealmate.enums.OrderStatus;
import com.mealmate.request.OrderRequest;
import com.mealmate.response.OrderResponse;
import com.mealmate.response.OrderStatusResponse;
import com.mealmate.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return new ResponseEntity<>(response,CREATED);
    }


    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>("Order cancelled",NO_CONTENT);

    }
    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable long orderId) {

        return new ResponseEntity<>(orderService.getOrder(orderId),ACCEPTED);

    }
    @GetMapping("/getOrderStatus/{orderId}")
    public ResponseEntity<OrderStatusResponse> getOrderStatus(@PathVariable long orderId) {

        return new ResponseEntity<>(orderService.getStatus(orderId),ACCEPTED);

    }

    @PutMapping("/updateOrder")
    public ResponseEntity<OrderStatusResponse> updateOrderStatus(@RequestParam long orderId, @RequestBody OrderStatus status) {

        return new ResponseEntity<>(orderService.updateStatus(orderId,status),ACCEPTED);

    }
}
