package com.smartpoi.exception;

import java.util.function.Predicate;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class ColumnNotFoundException extends ColumnVisitException {
    public ColumnNotFoundException(Predicate condition) {
        super(notFoundMessage(SUBJECT_TEXT, condition));
    }
}
