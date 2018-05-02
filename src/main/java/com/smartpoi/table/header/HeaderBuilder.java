package com.smartpoi.table.header;

import com.smartpoi.visitors.cell.CellVisitor;

public interface HeaderBuilder<C extends Column> extends CellVisitor {
    TableHeader<C> build();
}
