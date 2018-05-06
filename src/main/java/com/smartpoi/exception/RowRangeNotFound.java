package com.smartpoi.exception;

import java.util.function.Predicate;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class RowRangeNotFound extends RowVisitException {

    public RowRangeNotFound(Predicate condition) {
        super(notFoundMessage(ROW_TEXT, condition));
    }
}
