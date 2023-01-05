package com.ecommerce.cart.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;

@UtilityClass
public class Headers {
    private final String RESULT_COUNT_HEADER = "X-Result-Count";

    public static ResponseEntity.BodyBuilder singleResultCount(ResponseEntity.BodyBuilder body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(RESULT_COUNT_HEADER, "1-1/1");
        return body.headers(headers);
    }

    public static ResponseEntity.BodyBuilder formatResultCount(ResponseEntity.BodyBuilder body, Integer numberOfElements, Long totalElements, Integer page, Integer size) {
        HttpHeaders headers = new HttpHeaders();
        if (size == 0 || totalElements == 0 || numberOfElements == 0) {
            headers.add(RESULT_COUNT_HEADER, format("%s-%s/%s", 0, 0, totalElements));
        } else {
            headers.add(RESULT_COUNT_HEADER, format("%s-%s/%s", page * size + 1, Math.min(((long) page * size) + size, totalElements), totalElements));
        }

        return body.headers(headers);
    }
}
