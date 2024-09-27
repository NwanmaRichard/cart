package com.example.cart.service.order;

import com.example.cart.dto.OrderDto;
import com.example.cart.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    //Helper method to convert order to orderDto to be sent as a response to the user
    OrderDto convertToDto(Order order);
}
