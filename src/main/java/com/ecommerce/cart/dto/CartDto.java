package com.ecommerce.cart.dto;

import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class CartDto implements Serializable {
    private static final long serialVersionUID = 550097186758273324L;

    private List<CartProductDto> products;

    public static CartDto factoryCartDto(Cart cart) {
        return CartDto.builder()
                .products(cart.getCartProducts().stream().map(CartProductDto::factoryCartProductDto).collect(Collectors.toList()))
                .build();
    }
}

