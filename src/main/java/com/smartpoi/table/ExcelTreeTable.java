package com.smartpoi.table;

import com.google.common.collect.Table;
import com.smartpoi.table.header.TableHeader;

public class ExcelTreeTable<R extends Comparable, C extends Comparable> extends AbstractExcelSubTable<R, C> {

    public ExcelTreeTable(TableHeader tableHeader,
                          Table<R, C, org.apache.poi.ss.usermodel.Cell> table) {
        super(tableHeader, table);
    }
}
