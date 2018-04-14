package com.smartpoi.table.header;

import com.smartpoi.visitors.cell.CellVisitor;

public interface HeaderBuilder extends CellVisitor {
    TableHeader build();
}
