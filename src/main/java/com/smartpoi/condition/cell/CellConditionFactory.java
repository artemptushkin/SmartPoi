package com.smartpoi.condition.cell;

public interface CellConditionFactory {
    CellCondition eqIgnoreCase(String expectedValue);
    CellCondition containsIgnoreCase(String checkedValue);
    CellCondition columnIndex(int columnIndex);
    CellCondition emptyCell();
    CellCondition anyMatchCompositeCellCondition(CellCondition... conditions);
}
