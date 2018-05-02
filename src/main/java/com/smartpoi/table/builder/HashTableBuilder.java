package com.smartpoi.table.builder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.smartpoi.mapper.cell.CellMapper;
import com.smartpoi.table.ExcelHashTable;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Cell;

public class HashTableBuilder<R, C> extends AbstractTableBuilder<R, C> {

    public HashTableBuilder(HeaderBuilder<C> headerBuilder,
                            SheetVisitor headerSheetVisitor,
                            CellMapper<R> cellToRow) {
        super(headerBuilder, headerSheetVisitor, cellToRow);
    }

    @Override
    protected Table<R, C, Cell> createPoiTable() {
        return HashBasedTable.create();
    }

    @Override
    protected HeaderConditionalCellVisitor createTableBuilder(TableHeader<C> tableHeader) {
        return new HashConditionalCellVisitor(tableHeader);
    }

    @Override
    protected ExcelSubTable<R, C> buildTable(TableHeader<C> tableHeader,
                                                               Table<R, C, Cell> table) {
        return new ExcelHashTable<>(tableHeader, table);
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
