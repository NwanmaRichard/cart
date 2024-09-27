package com.example.cart.dto;

import com.example.cart.model.Product;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
