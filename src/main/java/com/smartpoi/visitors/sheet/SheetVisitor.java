package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public interface SheetVisitor extends Consumer<Sheet> {

    static SheetVisitor defaultVisitor(RowVisitor rowVisitor) {
        return rows -> StreamSupport.stream(rows.spliterator(), false)
                .forEach(rowVisitor);
    }

    static SheetVisitor defaultVisitorWithFilter(RowVisitor rowVisitor, RowCondition rowCondition) {
        return rows -> StreamSupport.stream(rows.spliterator(), false)
                .filter(rowCondition)
                .forEach(rowVisitor);
    }
}
