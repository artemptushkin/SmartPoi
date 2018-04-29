package com.smartpoi.table.builder;

import com.smartpoi.table.header.ComparableColumn;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;

public class TreeTableBuildHandler extends AbstractTableBuildHandler<Integer, ComparableColumn> {

    public TreeTableBuildHandler(HeaderBuilder headerBuilder, SheetVisitor headerSheetVisitor) {
        super(headerBuilder, headerSheetVisitor);
    }

    @Override
    protected ExcelTreeTableBuilder createTableBuilder(TableHeader<ComparableColumn> header) {
        return new ExcelTreeTableBuilder(header);
    }
}
