package com.smartpoi.table.header;

import com.smartpoi.visitors.cell.CellVisitor;

public interface HeaderBuilder<C> extends CellVisitor {
    TableHeader<C> build();
}
