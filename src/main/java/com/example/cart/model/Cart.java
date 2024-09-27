package com.example.cart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, orphanRemoval = true)  // this means that when a cart is deleted all the ies in the cart should also be deleted
    private Set<CartItem> items = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void addItem(CartItem item) {
        this.items.add(item);
        item.setCart(this);
        updateTotalAmount();
    }

    public void removeItem(CartItem item) {
        this.items.remove(item);
        item.setCart(null); //The item does not belong to that cart again
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        this.totalAmount = items.stream()
                .map(item -> {
                   BigDecimal unitPrice =  item.getUnitPrice();
                    if(unitPrice == null){
                        return BigDecimal.ZERO;
                    }
                    return unitPrice.multiply(BigDecimal.valueOf(item.getQuantity()));
                }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}



//NOTE: The reduce method is a terminal operation that combines the elements of a stream into a single value.
// It takes two parameters: an identity value and a binary operator.

// BigDecimal.ZERO:
//
//This is the identity value for the reduction. In the context of summing up a list of BigDecimal values,
// BigDecimal.ZERO serves as the initial value (starting point) for the accumulation.
//Identity Value: The identity value is the value that, when combined with any element in the stream using the given operator,
// returns the element itself. For addition, BigDecimal.ZERO is the identity because adding zero to any number does not change the number.

//BigDecimal::add:
//
//This is a method reference to the add method of the BigDecimal class.
// It serves as the binary operator that defines how two elements are combined.
//Binary Operator: A binary operator takes two inputs and produces a single output.
// In this case, BigDecimal::add takes two BigDecimal values and returns their sum.
























