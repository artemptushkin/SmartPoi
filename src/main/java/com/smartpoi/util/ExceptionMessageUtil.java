package com.smartpoi.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ExceptionMessageUtil {
    private ExceptionMessageUtil(){}

    public static String notFoundMessage(String subject, Predicate condition) {
        return String.format("%s not found by condition: %s", subject, condition);
    }

    public static String notFoundMessage(String subject, Predicate... conditions) {
        return String.format("%s not found by condition: %s", subject, Arrays.toString(conditions));
    }
}
