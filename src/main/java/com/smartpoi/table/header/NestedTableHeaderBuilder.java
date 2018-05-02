package com.smartpoi.table.header;

import com.smartpoi.mapper.cell.CellMapper;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;

import java.util.LinkedHashMap;
import java.util.Map;

public class NestedTableHeaderBuilder<C> implements HeaderBuilder<C> {

    private final Map<Integer, C> indexToColumn;
    private final CellMapper<C> cellMapper;

    @Setter
    private int rowNum;

    public NestedTableHeaderBuilder(CellMapper<C> cellMapper) {
        this.cellMapper = cellMapper;
        this.indexToColumn = new LinkedHashMap<>();
        this.rowNum = -1;
    }

    @Override
    public TableHeader<C> build() {
        return new NestedTableHeader<>(indexToColumn, rowNum);
    }

    @Override
    public void accept(Cell cell) {
        setRowNum(cell.getRowIndex());
        C column = cellMapper.apply(cell);
        indexToColumn.put(cell.getColumnIndex(), column);
    }
}
