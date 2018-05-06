package com.smartpoi.visitors.workbook;

import com.smartpoi.condition.sheet.SheetCondition;
import com.smartpoi.exception.SheetNotFoundException;
import com.smartpoi.exception.SheetVisitException;
import com.smartpoi.stream.consumer.FirstChildVisitor;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Optional;
import java.util.function.Supplier;

public class SingleSheetWorkbookVisitor extends FirstChildVisitor<Workbook, Sheet> implements WorkbookVisitor {

    public SingleSheetWorkbookVisitor(SheetCondition sheetCondition, SheetVisitor sheetVisitor) {
        super(sheetVisitor, sheetCondition);
    }

    @Override
    protected Sheet orElseCustom(Workbook workbook, Optional<Sheet> optionalSheet) {
        return optionalSheet.orElseThrow(sheetNotFoundException());
    }

    private Supplier<SheetVisitException> sheetNotFoundException() {
        return () -> new SheetNotFoundException(getCondition());
    }
}
