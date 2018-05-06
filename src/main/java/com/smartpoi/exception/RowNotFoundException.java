package com.smartpoi.exception;

import java.util.function.Predicate;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class RowNotFoundException extends RowVisitException {
    public RowNotFoundException(Predicate condition) {
        super(notFoundMessage(ROW_TEXT, condition));
    }
}
