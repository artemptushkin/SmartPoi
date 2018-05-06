package com.smartpoi.table.header;

public interface TableHeader<C> {
    boolean containsIndex(int column);

    C getColumn(int columnIndex);

    int getFirstIndex();

    int getExcelRowNum();

    int getColumnsSize();
}
