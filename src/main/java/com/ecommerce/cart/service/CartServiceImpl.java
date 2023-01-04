package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.exception.NotFoundException;
import com.ecommerce.cart.repository.CartProductRepository;
import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.cart.util.ConditionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.ecommerce.cart.constant.ErrorMessageConstants.NO_CART_FOUND_EXCEPTION_MESSAGE;


@Service
public class CartServiceImpl implements CartService {
    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public Cart getCart(Long userId) {
        Cart cart = this.cartRepository.findByUserId(userId);
        if (ConditionUtils.isEmpty(cart)) {
            throw new NotFoundException(NO_CART_FOUND_EXCEPTION_MESSAGE);
        }

        log.debug("Finished to get the cart. cart: {}", cart.getId());
        return cart;
    }

    public void clearCart(Long userId) {
        Cart cart = this.getCart(userId);
        this.cartRepository.delete(cart);
    }
}