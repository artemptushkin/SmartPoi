package com.smartpoi.condition.row;

import com.smartpoi.condition.cell.CellCondition;
import lombok.NonNull;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.StreamSupport;

public class AnyMatchCellRowCondition implements RowCondition {

    private final CellCondition firstRowCellCondition;

    public AnyMatchCellRowCondition(@NonNull CellCondition firstRowCellCondition) {
        this.firstRowCellCondition = firstRowCellCondition;
    }

    @Override
    public boolean test(Row row) {
        return StreamSupport.stream(row.spliterator(), false)
                .anyMatch(firstRowCellCondition);
    }

    @Override
    public String toString() {
        return "AnyMatchCellRowCondition{" +
                "firstRowCellCondition=" + firstRowCellCondition +
                '}';
    }
}
