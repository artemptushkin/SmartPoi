package com.smartpoi.table.builder;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.visitors.cell.CellVisitor;

public interface TableBuilder<R, C> extends CellVisitor, CellCondition {
    ExcelSubTable<R, C> buildTable();
}
