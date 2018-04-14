package com.smartpoi.table;

import com.google.common.collect.HashBasedTable;
import com.smartpoi.table.header.TableHeader;

public class ExcelHashTable<R, C> extends WrappedTable<R, C> {
    private final TableHeader tableHeader;

    public ExcelHashTable(TableHeader tableHeader) {
        super(HashBasedTable.create());
        this.tableHeader = tableHeader;
    }
}
