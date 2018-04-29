package com.smartpoi.table.builder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.smartpoi.table.ExcelHashTable;
import com.smartpoi.table.header.DefaultColumn;
import com.smartpoi.table.header.TableHeader;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelHashTableBuilder implements TableBuilder<Integer, DefaultColumn> {
    private final TableHeader<DefaultColumn> header;
    private final Table<Integer, DefaultColumn, Cell> table;

    public ExcelHashTableBuilder(TableHeader<DefaultColumn> header) {
        this.header = header;
        this.table = HashBasedTable.create();
    }

    @Override
    public ExcelHashTable<Integer, DefaultColumn> buildTable() {
        return new ExcelHashTable<>(header, table);
    }

    @Override
    public void accept(Cell cell) {
        DefaultColumn column = header.getColumn(cell.getColumnIndex());
        table.put(cell.getRowIndex(), column, cell);
    }

    @Override
    public boolean test(Cell cell) {
        return header.containsIndex(cell.getColumnIndex());
    }
}
