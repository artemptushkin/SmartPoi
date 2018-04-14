package com.smartpoi.table.header;

import com.smartpoi.mapper.column.CellToColumn;
import org.apache.poi.ss.usermodel.Cell;

import java.util.LinkedHashMap;
import java.util.Map;

public class NestedTableHeaderBuilder implements HeaderBuilder {

    private final Map<Integer, Column> indexToColumn;
    private final CellToColumn cellMapper;

    public NestedTableHeaderBuilder(CellToColumn cellMapper) {
        this.cellMapper = cellMapper;
        this.indexToColumn = new LinkedHashMap<>();
    }

    @Override
    public TableHeader build() {
        return new NestedTableHeader(indexToColumn);
    }

    @Override
    public void accept(Cell cell) {
        Column column = cellMapper.apply(cell);
        indexToColumn.put(cell.getColumnIndex(), column);
    }
}
