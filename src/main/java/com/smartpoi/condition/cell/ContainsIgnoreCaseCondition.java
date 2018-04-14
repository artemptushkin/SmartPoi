package com.smartpoi.condition.cell;

import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ContainsIgnoreCaseCondition extends CellValueCondition {

    public ContainsIgnoreCaseCondition(@NonNull String expectedValue, @NonNull DataFormatter dataFormatter) {
        super(expectedValue.toLowerCase(), dataFormatter);
    }

    @Override
    public boolean test(Cell cell) {
        return dataFormatter
                .formatCellValue(cell)
                .toLowerCase()
                .contains(expectedValue);
    }
}
