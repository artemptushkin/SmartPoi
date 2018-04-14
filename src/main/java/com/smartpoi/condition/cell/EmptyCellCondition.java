package com.smartpoi.condition.cell;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class EmptyCellCondition implements CellCondition {

    @Override
    public boolean test(Cell cell) {
        return cell == null || cell.getCellTypeEnum() == CellType.BLANK;
    }
}
