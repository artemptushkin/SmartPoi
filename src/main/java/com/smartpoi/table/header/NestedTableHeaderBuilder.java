package com.smartpoi.table.header;

import com.smartpoi.mapper.column.CellToColumn;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;

import java.util.LinkedHashMap;
import java.util.Map;

public class NestedTableHeaderBuilder implements HeaderBuilder {

    private final Map<Integer, Column> indexToColumn;
    private final CellToColumn cellMapper;

    @Setter
    private int rowNum;

    public NestedTableHeaderBuilder(CellToColumn cellMapper) {
        this.cellMapper = cellMapper;
        this.indexToColumn = new LinkedHashMap<>();
        this.rowNum = -1;
    }

    @Override
    public TableHeader build() {
        return new NestedTableHeader<>(indexToColumn, rowNum);
    }

    @Override
    public void accept(Cell cell) {
        setRowNum(cell.getRowIndex());
        Column column = cellMapper.apply(cell);
        indexToColumn.put(cell.getColumnIndex(), column);
    }
}
