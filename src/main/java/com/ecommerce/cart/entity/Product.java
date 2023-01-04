package com.ecommerce.cart.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "products")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "discount_price")
    private Double discountPrice;

    private String description;
    private Double price;
    private String thumbnail;

}
