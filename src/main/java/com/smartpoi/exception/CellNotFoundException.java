package com.smartpoi.exception;

import java.util.function.Predicate;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class CellNotFoundException extends CellVisitException {

    public CellNotFoundException(Predicate predicate) {
        super(notFoundMessage(CELL_TEXT, predicate));
    }

    public CellNotFoundException(Predicate... predicates) {
        super(notFoundMessage(CELL_TEXT, predicates));
    }
}
