package com.smartpoi.exception;

import java.util.function.Predicate;

public class RowNotFoundException extends RowVisitException {
    public RowNotFoundException(Predicate condition) {
        super(String.format("Row not found by condition: %s", condition));
    }
}
