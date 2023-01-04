package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.Cart;
import org.springframework.stereotype.Service;


@Service
public interface CartService {
    /**
     * Returns the cart that belongs to a user
     *
     * @param userId      user id
     * @return cart object
     */
    Cart getCart(Long userId);

    /**
     * Removes all products from cart
     *
     * @param userId      the user id
     */
    void clearCart(Long userId);
}
