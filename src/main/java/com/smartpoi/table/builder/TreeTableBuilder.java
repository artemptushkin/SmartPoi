package com.smartpoi.table.builder;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import com.smartpoi.mapper.cell.CellMapper;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.ExcelTreeTable;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Cell;

public class TreeTableBuilder<R extends Comparable, C extends Comparable> extends AbstractTableBuilder<R, C> {

    public TreeTableBuilder(HeaderBuilder<C> headerBuilder,
                            SheetVisitor headerSheetVisitor,
                            CellMapper<R> cellToRow) {
        super(headerBuilder, headerSheetVisitor, cellToRow);
    }

    @Override
    protected Table<R, C, Cell> createPoiTable() {
        return TreeBasedTable.create();
    }

    @Override
    protected ExcelSubTable<R, C> buildTable(TableHeader<C> header,
                                                                  Table<R, C, Cell> table) {
        return new ExcelTreeTable<>(header, table);
    }

    @Override
    protected HeaderConditionalCellVisitor createTableBuilder(TableHeader<C> header) {
        return new HashConditionalCellVisitor(header);
    }

    public class HashConditionalCellVisitor extends HeaderConditionalCellVisitor<C> {

        public HashConditionalCellVisitor(TableHeader<C> header) {
            super(header);
        }

        @Override
        public void accept(Cell cell) {
            C column = getHeader().getColumn(cell.getColumnIndex());
            R row = getCellToRow().apply(cell);
            put(row, column, cell);
        }
    }
}
