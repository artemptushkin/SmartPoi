package com.smartpoi.visitors.workbook;

import com.smartpoi.condition.sheet.SheetCondition;
import com.smartpoi.exception.SheetNotFoundException;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Optional;
import java.util.stream.StreamSupport;

public class SingleSheetWorkbookVisitor implements WorkbookVisitor {
    private final SheetCondition sheetCondition;
    private final SheetVisitor sheetVisitor;

    public SingleSheetWorkbookVisitor(SheetCondition sheetCondition, SheetVisitor sheetVisitor) {
        this.sheetCondition = sheetCondition;
        this.sheetVisitor = sheetVisitor;
    }

    @Override
    public void accept(Workbook workbook) {
        Optional<Sheet> sheetOptional = StreamSupport.stream(workbook.spliterator(), false)
                .filter(sheetCondition)
                .findFirst();
        if (sheetOptional.isPresent()) {
            sheetVisitor.accept(sheetOptional.get());
        } else {
            throw new SheetNotFoundException(sheetCondition);
        }
    }
}
