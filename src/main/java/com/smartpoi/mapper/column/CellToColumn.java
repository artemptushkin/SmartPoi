package com.smartpoi.mapper.column;

import com.smartpoi.mapper.cell.CellMapper;
import com.smartpoi.table.header.Column;
import org.apache.poi.ss.usermodel.Cell;

@FunctionalInterface
public interface CellToColumn<T> extends CellMapper<Column<T>> {
    @Override
    Column<T> apply(Cell cell);
}
