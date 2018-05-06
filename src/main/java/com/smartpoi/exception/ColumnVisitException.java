package com.smartpoi.exception;

public class ColumnVisitException extends RuntimeException {
    static final String SUBJECT_TEXT = "Column";

    protected ColumnVisitException(String message) {
        super(message);
    }
}
