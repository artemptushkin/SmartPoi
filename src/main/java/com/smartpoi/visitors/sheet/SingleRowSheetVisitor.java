package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.exception.RowNotFoundException;
import com.smartpoi.exception.RowVisitException;
import com.smartpoi.stream.consumer.FirstChildVisitor;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Optional;
import java.util.function.Supplier;

public class SingleRowSheetVisitor extends FirstChildVisitor<Sheet, Row> implements SheetVisitor {

    public SingleRowSheetVisitor(RowCondition rowCondition, RowVisitor rowVisitor) {
        super(rowVisitor, rowCondition);
    }

    @Override
    protected Row orElseCustom(Sheet sheet, Optional<Row> rowOptional) {
        return rowOptional.orElseThrow(rowNotFoundException());
    }

    private Supplier<RowVisitException> rowNotFoundException() {
        return () -> new RowNotFoundException(getCondition());
    }
}
