package com.ecommerce.cart.exception;

import com.ecommerce.cart.constant.ErrorCodeConstants;
import com.ecommerce.cart.dto.DtoResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;

@ControllerAdvice
@Priority(1)
public class CartExceptionHandler {
    public CartExceptionHandler() { /* we will use this constructor later if needed */ }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseBody
    public ResponseEntity<DtoResponse> handleNoCartItemFoundExceptionMessage(NotFoundException ex) {
        return new ResponseEntity<>(new DtoResponse(404, ex.getMessage(), ErrorCodeConstants.NOT_FOUND), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {InvalidMessageException.class})
    @ResponseBody
    public ResponseEntity<DtoResponse> handleInvalidMessageException(InvalidMessageException ex) {
        return new ResponseEntity<>(new DtoResponse(400, ex.getExceptionMessage(), ErrorCodeConstants.BAD_REQUEST), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

