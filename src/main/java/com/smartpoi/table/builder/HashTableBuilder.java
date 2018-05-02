package com.smartpoi.table.builder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.smartpoi.table.ExcelHashTable;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.header.DefaultColumn;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Cell;

public class HashTableBuilder extends AbstractTableBuilder<Integer, DefaultColumn> {

    public HashTableBuilder(HeaderBuilder headerBuilder, SheetVisitor headerSheetVisitor) {
        super(headerBuilder, headerSheetVisitor);
    }

    @Override
    protected Table<Integer, DefaultColumn, Cell> createPoiTable() {
        return HashBasedTable.create();
    }

    @Override
    protected HeaderConditionalCellVisitor createTableBuilder(TableHeader<DefaultColumn> tableHeader) {
        return new HashConditionalCellVisitor(tableHeader);
    }

    @Override
    protected ExcelSubTable<Integer, DefaultColumn> buildTable(TableHeader<DefaultColumn> tableHeader,
                                                               Table<Integer, DefaultColumn, Cell> table) {
        return new ExcelHashTable<>(tableHeader, table);
    }

    public class HashConditionalCellVisitor extends HeaderConditionalCellVisitor<DefaultColumn> {

        public HashConditionalCellVisitor(TableHeader<DefaultColumn> header) {
            super(header);
        }

        @Override
        public void accept(Cell cell) {
            DefaultColumn column = getHeader().getColumn(cell.getColumnIndex());
            put(cell.getRowIndex(), column, cell);
        }
    }
}
