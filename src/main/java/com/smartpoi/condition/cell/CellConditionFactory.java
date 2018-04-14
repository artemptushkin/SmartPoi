package com.smartpoi.condition.cell;

public interface CellConditionFactory {
    CellCondition eqIgnoreCaseCondition(String expectedValue);
    CellCondition containsIgnoreCaseCondition(String checkedValue);
    CellCondition columnIndexCondition(int columnIndex);
    CellCondition emptyCellCondition();
    CellCondition anyMatchCompositeCellCondition(CellCondition... conditions);
}
