package com.smartpoi.table;

import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.Cell;

public interface ExcelSubTable<R, C> extends Table<R, C, Cell> {
}
