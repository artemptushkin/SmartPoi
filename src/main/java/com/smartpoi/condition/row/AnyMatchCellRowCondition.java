package com.smartpoi.condition.row;

import com.smartpoi.condition.cell.CellCondition;
import lombok.NonNull;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.StreamSupport;

@ToString(of = "firstRowCellCondition")
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
}
