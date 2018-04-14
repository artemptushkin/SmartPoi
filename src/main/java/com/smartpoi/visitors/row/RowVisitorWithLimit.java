package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class RowVisitorWithLimit implements RowVisitor {
    private final long limit;
    private final Consumer<Cell> cellConsumer;
    private final CellCondition cellCondition;

    public RowVisitorWithLimit(Consumer<Cell> cellConsumer, CellCondition cellCondition, long limit) {
        this.cellCondition = cellCondition;
        this.limit = limit;
        this.cellConsumer = cellConsumer;
    }

    @Override
    public void accept(Row row) {
        StreamSupport.stream(row.spliterator(), false)
                .limit(limit)
                .filter(cellCondition)
                .forEach(cellConsumer);
    }
}
