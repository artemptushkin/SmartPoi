package com.smartpoi.exception;

import java.util.function.Predicate;

public class ColumnNotFoundException extends ColumnVisitException {
    public ColumnNotFoundException(Predicate condition) {
        super(String.format("Column not found by condition: %s", condition));
    }
}
