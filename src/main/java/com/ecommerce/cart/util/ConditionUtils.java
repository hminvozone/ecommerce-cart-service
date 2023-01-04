package com.ecommerce.cart.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;

@UtilityClass
public class ConditionUtils {
    public static <T> Boolean isEmpty(T value) {
        return Optional.ofNullable(value).isEmpty();
    }

    public static Boolean isListEmpty(List<?> value) {
        return isEmpty(value) || value.isEmpty();
    }

    public static Boolean isNullOrNegativeValue(Long value) {
        return (isEmpty(value) || value <= 0);
    }

    public static Boolean isNullOrNegativeValue(Integer value) {
        return (isEmpty(value) || value <= 0);
    }

    public static Boolean isNegative(Integer value) {
        return (value <= 0);
    }
}