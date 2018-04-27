package com.smartpoi.table.header;

import com.smartpoi.condition.column.ColumnCondition;

import java.util.Map;

public class NestedTableHeader<C extends Column> implements TableHeader<C> {
    private final Map<Integer, C> indexToColumn;

    NestedTableHeader(Map<Integer, C> indexToColumn) {
        this.indexToColumn = indexToColumn;
    }

    @Override
    public boolean containsIndex(int column) {
        return indexToColumn.containsKey(column);
    }

    @Override
    public C getColumn(int columnIndex) {
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
