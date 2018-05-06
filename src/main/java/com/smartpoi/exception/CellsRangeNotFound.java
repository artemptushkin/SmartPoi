package com.smartpoi.exception;

import java.util.function.Predicate;

public class CellsRangeNotFound extends CellNotFoundException {
    public CellsRangeNotFound(Predicate predicate) {
        super(predicate);
    }
}
