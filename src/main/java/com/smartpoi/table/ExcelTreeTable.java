package com.smartpoi.table;

import com.google.common.collect.TreeBasedTable;
import com.smartpoi.table.header.ComparableColumn;
import com.smartpoi.table.header.TableHeader;

public class ExcelTreeTable<R extends Comparable> extends WrappedTable<R, ComparableColumn> {
    private final TableHeader tableHeader;

    public ExcelTreeTable(TableHeader tableHeader) {
        super(TreeBasedTable.create());
        this.tableHeader = tableHeader;
    }

}
