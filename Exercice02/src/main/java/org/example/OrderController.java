package org.example;

import java.util.UUID;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public void createOrder(Order order) {
        String orderId = UUID.randomUUID().toString();
        order.setId(orderId);
        orderService.createOrder(order);
    }
}
