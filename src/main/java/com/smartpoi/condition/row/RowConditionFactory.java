package com.smartpoi.condition.row;

import com.smartpoi.condition.cell.CellCondition;

public interface RowConditionFactory {
    RowCondition anyMatchCellRowCondition(CellCondition firstRowCellCondition);
}
