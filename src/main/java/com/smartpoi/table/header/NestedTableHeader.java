package com.smartpoi.table.header;

import com.smartpoi.condition.column.ColumnCondition;

import java.util.Map;

public class NestedTableHeader implements TableHeader {
    private final Map<Integer, Column> indexToColumn;

    NestedTableHeader(Map<Integer, Column> indexToColumn) {
        this.indexToColumn = indexToColumn;
    }

    @Override
    public boolean containsIndex(int column) {
        return indexToColumn.containsKey(column);
    }

    @Override
    public Column getColumn(int columnIndex) {
        return indexToColumn.get(columnIndex);
    }

    @Override
    public int getColumnsSize() {
        return indexToColumn.size();
    }

    @Override
    public void filterByCondition(ColumnCondition columnCondition) {
        indexToColumn.entrySet()
                .removeIf(entry ->
                        columnCondition.negate().test(entry.getValue()));
    }
}
