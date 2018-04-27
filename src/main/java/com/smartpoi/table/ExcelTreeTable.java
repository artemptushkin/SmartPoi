package com.smartpoi.table;

import com.google.common.collect.Table;
import com.smartpoi.table.header.ComparableColumn;
import com.smartpoi.table.header.TableHeader;

public class ExcelTreeTable<R, C extends ComparableColumn> extends WrappedTable<R, C> {
    private final TableHeader tableHeader;

    public ExcelTreeTable(TableHeader tableHeader,
                          Table<R, C, org.apache.poi.ss.usermodel.Cell> table) {
        super(table);
        this.tableHeader = tableHeader;
    }

}
