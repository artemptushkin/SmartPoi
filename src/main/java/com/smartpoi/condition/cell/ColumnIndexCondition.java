package com.smartpoi.condition.cell;

import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;

public class ColumnIndexCondition implements CellCondition {
    private final Integer columnIndex;

    public ColumnIndexCondition(@NonNull Integer columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public boolean test(Cell cell) {
        return columnIndex.equals(cell.getColumnIndex());
    }
}
