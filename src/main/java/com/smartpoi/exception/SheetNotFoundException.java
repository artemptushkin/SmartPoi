package com.smartpoi.exception;

import com.smartpoi.condition.sheet.SheetCondition;

public class SheetNotFoundException extends SheetVisitException {
    public SheetNotFoundException(SheetCondition sheetCondition) {
        super(String.format("Sheet not found by condition: %s", sheetCondition));
    }
}
