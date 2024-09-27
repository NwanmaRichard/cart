package com.example.cart.service.cart;

import com.example.cart.model.Cart;
import com.example.cart.model.User;

import java.math.BigDecimal;

public interface ICartService  {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
