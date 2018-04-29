package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Row;

import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public interface RowVisitor extends Consumer<Row> {

    static RowVisitor defaultVisitor(CellVisitor cellVisitor) {
        return row -> StreamSupport.stream(row.spliterator(), false)
                .forEach(cellVisitor);
    }

    static RowVisitor visitorWithFilter(CellVisitor cellVisitor, CellCondition cellCondition) {
        return row -> StreamSupport.stream(row.spliterator(), false)
                .filter(cellCondition)
                .forEach(cellVisitor);
    }
}
