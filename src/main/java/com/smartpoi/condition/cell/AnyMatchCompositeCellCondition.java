package com.smartpoi.condition.cell;

import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;

public class AnyMatchCompositeCellCondition extends CompositeCellCondition {

    public AnyMatchCompositeCellCondition(@NonNull CellCondition... conditions) {
        super(conditions);
    }

    @Override
    public boolean test(Cell cell) {
        return getConditions()
                .stream()
                .anyMatch(cellCondition -> cellCondition.test(cell));
    }
}
