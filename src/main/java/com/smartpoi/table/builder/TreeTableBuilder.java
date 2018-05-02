package com.smartpoi.table.builder;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.ExcelTreeTable;
import com.smartpoi.table.header.ComparableColumn;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Cell;

public class TreeTableBuilder extends AbstractTableBuilder<Integer, ComparableColumn> {

    public TreeTableBuilder(HeaderBuilder headerBuilder, SheetVisitor headerSheetVisitor) {
        super(headerBuilder, headerSheetVisitor);
    }

    @Override
    protected Table<Integer, ComparableColumn, Cell> createPoiTable() {
        return TreeBasedTable.create();
    }

    @Override
    protected ExcelSubTable<Integer, ComparableColumn> buildTable(TableHeader<ComparableColumn> header,
                                                                  Table<Integer, ComparableColumn, Cell> table) {
        return new ExcelTreeTable<>(header, table);
    }

    @Override
    protected HeaderConditionalCellVisitor createTableBuilder(TableHeader<ComparableColumn> header) {
        return new HashConditionalCellVisitor(header);
    }

    public class HashConditionalCellVisitor extends HeaderConditionalCellVisitor<ComparableColumn> {

        public HashConditionalCellVisitor(TableHeader<ComparableColumn> header) {
            super(header);
        }

        /* todo key = index (Integer) - fix */
        @Override
        public void accept(Cell cell) {
            ComparableColumn column = getHeader().getColumn(cell.getColumnIndex());
            put(cell.getRowIndex(), column, cell);
        }
    }
}
