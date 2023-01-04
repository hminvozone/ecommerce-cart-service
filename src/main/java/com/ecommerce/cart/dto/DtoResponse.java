package com.ecommerce.cart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DtoResponse implements Serializable {
    private static final long serialVersionUID = 5257529090904948800L;

    private Integer statusCode;
    private String message;
    private String error;

    public DtoResponse(Integer statusCode, String message, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }
}
