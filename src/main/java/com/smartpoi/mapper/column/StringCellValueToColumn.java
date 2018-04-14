package com.smartpoi.mapper.column;

import com.smartpoi.table.header.ComparableColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class StringCellValueToColumn extends CellValueToColumn<String> {

    public StringCellValueToColumn(DataFormatter dataFormatter) {
        super(dataFormatter);
    }

    @Override
    protected ComparableColumn<String> cellToColumn(Cell cell) {
        String cellValue = getStringCellValue(cell);
        return new ComparableColumn<>(cellValue);
    }
}
