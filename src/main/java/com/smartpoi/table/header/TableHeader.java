package com.smartpoi.table.header;

import com.smartpoi.condition.column.ColumnCondition;

public interface TableHeader {
    boolean containsIndex(int column);

    Column getColumn(int columnIndex);

    int getColumnsSize();

    void filterByCondition(ColumnCondition columnCondition);
}
