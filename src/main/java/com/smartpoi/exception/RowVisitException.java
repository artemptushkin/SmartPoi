package com.smartpoi.exception;

public class RowVisitException extends RuntimeException {
    static final String ROW_TEXT = "Row";

    protected RowVisitException(String message) {
        super(message);
    }
}
