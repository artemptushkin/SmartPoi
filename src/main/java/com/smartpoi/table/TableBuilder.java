package com.smartpoi.table;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Workbook;

public interface TableBuilder<R, C> extends CellVisitor, CellCondition {
    ExcelSubTable<R, C> buildTable(Workbook workbook);
}
