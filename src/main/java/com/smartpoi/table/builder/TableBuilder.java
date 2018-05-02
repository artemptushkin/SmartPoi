package com.smartpoi.table.builder;

import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.header.Column;
import org.apache.poi.ss.usermodel.Sheet;

public interface TableBuilder<R, C extends Column> {
    ExcelSubTable<R, C> buildTable(Sheet sheet);
}
