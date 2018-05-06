package com.smartpoi.exception;

import com.smartpoi.condition.sheet.SheetCondition;

import static com.smartpoi.util.ExceptionMessageUtil.notFoundMessage;

public class SheetNotFoundException extends SheetVisitException {
    public SheetNotFoundException(SheetCondition sheetCondition) {
        super(notFoundMessage(SHEET_TEXT, sheetCondition));
    }
}
