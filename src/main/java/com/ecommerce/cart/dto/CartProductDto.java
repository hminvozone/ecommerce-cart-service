package com.ecommerce.cart.dto;

import com.ecommerce.cart.entity.CartProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class CartProductDto implements Serializable {
    private static final long serialVersionUID = 4090786113432938857L;

    private Integer id;
    private Integer qty;
    private Double price;
    private Double discountPrice;
    private Double totalPrice;

    public static CartProductDto factoryCartProductDto(CartProduct cartProduct) {
        return CartProductDto.builder()
                .id(cartProduct.getProduct().getId())
                .qty(cartProduct.getQty())
                .price(cartProduct.getPrice())
                .discountPrice(cartProduct.getDiscountPrice())
                .totalPrice(cartProduct.getTotalPrice())
                .build();
    }
}

