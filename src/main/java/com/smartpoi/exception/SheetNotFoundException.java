package com.smartpoi.exception;

import java.util.function.Predicate;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class SheetNotFoundException extends SheetVisitException {
    public SheetNotFoundException(Predicate sheetCondition) {
        super(notFoundMessage(SHEET_TEXT, sheetCondition));
    }
}
