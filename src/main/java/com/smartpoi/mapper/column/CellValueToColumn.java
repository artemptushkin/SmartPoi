package com.smartpoi.mapper.column;

import com.smartpoi.mapper.cell.CellValueMapper;
import com.smartpoi.table.header.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public abstract class CellValueToColumn<T> extends CellValueMapper<Column<T>> implements CellToColumn<T> {

    public CellValueToColumn(DataFormatter dataFormatter) {
        super(dataFormatter);
    }

    @Override
    public Column<T> apply(Cell cell) {
        return cellToColumn(cell);
    }

    protected abstract Column<T> cellToColumn(Cell cell);
}
