package com.smartpoi.condition.cell;

import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class EqIgnoreCaseCondition extends CellValueCondition {

    public EqIgnoreCaseCondition(@NonNull String expectedValue, @NonNull DataFormatter dataFormatter) {
        super(expectedValue, dataFormatter);
    }

    @Override
    public boolean test(Cell cell) {
        return dataFormatter
                .formatCellValue(cell)
                .equalsIgnoreCase(expectedValue);
    }
}
