package com.smartpoi.table.builder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.smartpoi.table.ExcelTreeTable;
import com.smartpoi.table.header.ComparableColumn;
import com.smartpoi.table.header.TableHeader;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelTreeTableBuilder implements TableBuilder<Integer, ComparableColumn> {
    private final TableHeader<ComparableColumn> header;
    private final Table<Integer, ComparableColumn, Cell> table;

    public ExcelTreeTableBuilder(TableHeader<ComparableColumn> header) {
        this.header = header;
        this.table = HashBasedTable.create();
    }

    @Override
    public ExcelTreeTable<Integer, ComparableColumn> buildTable() {
        return new ExcelTreeTable<>(header, table);
    }

    @Override
    public void accept(Cell cell) {
        ComparableColumn column = header.getColumn(cell.getColumnIndex());
        table.put(cell.getRowIndex(), column, cell);
    }

    @Override
    public boolean test(Cell cell) {
        return header.containsIndex(cell.getColumnIndex());
    }
}
