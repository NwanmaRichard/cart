package com.example.cart.service.cart;

import com.example.cart.model.Cart;
import com.example.cart.model.CartItem;

import java.math.BigDecimal;

public interface ICartItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);

    CartItem getCartItem(Long productId, Long cartId);

    void updateItemQuantity(Long cartId, Long productId, int quantity);
}
