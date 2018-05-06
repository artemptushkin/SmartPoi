package com.smartpoi.exception;

import java.util.function.Predicate;

public class CellNotFoundException extends CellVisitException {

    public CellNotFoundException(Predicate predicate) {
        super(String.format("Cell not found by condition: %s", predicate));
    }

    public CellNotFoundException(Predicate... predicates) {
        super(String.format("Cell not found by conditions: %s", predicates));
    }
}
