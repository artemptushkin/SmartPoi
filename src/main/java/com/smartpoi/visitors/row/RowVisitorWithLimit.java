package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.StreamSupport;

public class RowVisitorWithLimit implements RowVisitor {
    private final long limit;
    private final CellVisitor cellVisitor;
    private final CellCondition cellCondition;

    public RowVisitorWithLimit(CellVisitor cellVisitor, CellCondition cellCondition, long limit) {
        this.cellCondition = cellCondition;
        this.limit = limit;
        this.cellVisitor = cellVisitor;
    }

    @Override
    public void accept(Row row) {
        StreamSupport.stream(row.spliterator(), false)
                .limit(limit)
                .filter(cellCondition)
                .forEach(cellVisitor);
    }
}
