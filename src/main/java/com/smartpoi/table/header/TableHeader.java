package com.smartpoi.table.header;

import com.smartpoi.condition.column.ColumnCondition;

public interface TableHeader<C> {
    boolean containsIndex(int column);

    C getColumn(int columnIndex);

    int getColumnsSize();

    void filterByCondition(ColumnCondition columnCondition);
}
