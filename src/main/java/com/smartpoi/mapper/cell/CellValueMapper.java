package com.smartpoi.mapper.cell;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public abstract class CellValueMapper<T> implements CellMapper<T> {
    @Getter(value = AccessLevel.PROTECTED)
    private final DataFormatter dataFormatter;

    public CellValueMapper(DataFormatter dataFormatter) {
        this.dataFormatter = dataFormatter;
    }

    protected String getStringCellValue(Cell cell) {
        return dataFormatter.formatCellValue(cell);
    }
}
