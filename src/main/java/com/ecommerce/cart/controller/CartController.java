package com.ecommerce.cart.controller;

import com.ecommerce.cart.dto.CartDto;
import com.ecommerce.cart.repository.CartProductRepository;
import com.ecommerce.cart.repository.CartRepository;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.cart.util.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping({"/products/{id}"})
    public ResponseEntity<CartDto> cartProducts(@PathVariable(value = "id") Long userId) {
        CartDto cartDto = CartDto.factoryCartDto(this.cartService.getCart(userId));
        return Headers.singleResultCount(ResponseEntity.ok()).body(cartDto);
    }

    @DeleteMapping({"/{id}"})
    public void clearCart(@PathVariable(value = "id") Long userId) {
        this.cartService.clearCart(userId);
    }
}