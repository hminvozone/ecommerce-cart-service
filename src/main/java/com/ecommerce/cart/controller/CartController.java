package com.ecommerce.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping({"/products/{id}"})
    public String cartProducts(@PathVariable(value = "userId") Long userId) {
        logger.debug("cartProducts");
        return "cartProducts";
    }

    @DeleteMapping({"/{id}"})
    public void clearCart(@PathVariable(value = "userId") Long userId) {
        logger.debug("clearCart");
    }
}