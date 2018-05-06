package com.smartpoi.exception;

public class CellVisitException extends RuntimeException {
    static final String CELL_TEXT = "Cell";

    protected CellVisitException(String message) {
        super(message);
    }
}
