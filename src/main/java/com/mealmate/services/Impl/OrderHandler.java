package com.mealmate.services.Impl;

import com.mealmate.request.OrderRequest;
import com.mealmate.response.OrderResponse;
import lombok.Data;

@Data
public abstract class OrderHandler {
    OrderHandler next;



    public static OrderHandler processOrder(OrderHandler first, OrderHandler... chain) {
        OrderHandler head = first;
        for (OrderHandler nextInChain : chain) {
            head.setNext(nextInChain);
            head = nextInChain;
        }
        return first;
    }

    public abstract OrderResponse handleOrder(OrderRequest orderRequest , OrderResponse orderResponse);


    protected OrderResponse handleNext(OrderRequest orderRequest , OrderResponse orderResponse){
        if(next == null){
            return orderResponse;
        }
        return next.handleOrder(orderRequest,orderResponse);
    }
    public abstract OrderResponse handle(OrderRequest orderRequest , OrderResponse orderResponse);
}
