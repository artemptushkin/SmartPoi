package com.smartpoi.table.header;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;

public class NestedTableHeader<C> implements TableHeader<C> {
    private final Map<Integer, C> indexToColumn;
    @Getter(value = AccessLevel.PUBLIC)
    private final int excelRowNum;

    NestedTableHeader(Map<Integer, C> indexToColumn, int excelRowNum) {
        this.indexToColumn = indexToColumn;
        this.excelRowNum = excelRowNum;
    }

    @Override
    public int getFirstIndex() {
        if (!indexToColumn.entrySet().isEmpty()) {
            return indexToColumn.entrySet().iterator().next().getKey();
        }
        throw new IllegalArgumentException("Header is empty.");
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
}
