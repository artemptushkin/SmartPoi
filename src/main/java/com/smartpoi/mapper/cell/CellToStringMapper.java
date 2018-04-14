package com.smartpoi.mapper.cell;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class CellToStringMapper extends CellValueMapper<String> {
    public CellToStringMapper(DataFormatter dataFormatter) {
        super(dataFormatter);
    }

    @Override
    public String apply(Cell cell) {
        return getStringCellValue(cell);
    }
}
