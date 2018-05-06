package com.smartpoi.table;

import com.google.common.collect.Table;
import com.smartpoi.table.header.TableHeader;

public class ExcelHashTable<R, C> extends AbstractExcelSubTable<R, C> {

    public ExcelHashTable(TableHeader tableHeader,
                          Table<R, C, org.apache.poi.ss.usermodel.Cell> table) {
        super(tableHeader, table);
    }
}
