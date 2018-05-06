package com.smartpoi.exception;

public class SheetVisitException extends RuntimeException {
    static final String SHEET_TEXT = "Sheet";
    public SheetVisitException(String message) {
        super(message);
    }
}
