package com.smartpoi.table.builder;

import com.smartpoi.table.ExcelSubTable;
import org.apache.poi.ss.usermodel.Sheet;

public interface TableBuilder<R, C> {
    ExcelSubTable<R, C> buildTable(Sheet sheet);
}
