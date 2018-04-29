package com.smartpoi.table.builder;

import com.smartpoi.table.header.DefaultColumn;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;

public class HashTableBuildHandler extends AbstractTableBuildHandler<Integer, DefaultColumn> {

    public HashTableBuildHandler(HeaderBuilder headerBuilder, SheetVisitor headerSheetVisitor) {
        super(headerBuilder, headerSheetVisitor);
    }

    @Override
    protected ExcelHashTableBuilder createTableBuilder(TableHeader<DefaultColumn> header) {
        return new ExcelHashTableBuilder(header);
    }
}
