package com.smartpoi.table.header;

import com.smartpoi.condition.column.ColumnCondition;

public interface TableHeader<C extends Column> {
    boolean containsIndex(int column);

    C getColumn(int columnIndex);

    int getRowNum();

    int getColumnsSize();

    void filterByCondition(ColumnCondition columnCondition);
}
