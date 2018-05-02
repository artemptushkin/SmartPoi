package com.smartpoi.table.builder;

import com.google.common.collect.Table;
import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.header.Column;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.row.RowVisitor;
import com.smartpoi.visitors.sheet.SheetVisitor;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class AbstractTableBuilder<R, C extends Column> implements TableBuilder<R, C> {

    private final HeaderBuilder<C> headerBuilder;
    private final SheetVisitor headerSheetVisitor;
    @Getter(value = AccessLevel.PROTECTED)
    private final Table<R, C, Cell> table;

    public AbstractTableBuilder(HeaderBuilder headerBuilder,
                                SheetVisitor headerSheetVisitor) {
        this.headerBuilder = headerBuilder;
        this.headerSheetVisitor = headerSheetVisitor;
        table = createPoiTable();
    }

    @Override
    public ExcelSubTable<R, C> buildTable(Sheet sheet) {
        headerSheetVisitor.accept(sheet);
        TableHeader<C> header = headerBuilder.build();
        ConditionalCellVisitor conditionalCellVisitor = createTableBuilder(header);

        SheetVisitor sheetVisitorForTable = rowsVisitor(
                RowVisitor.visitorWithFilter(conditionalCellVisitor, conditionalCellVisitor),
                row -> row.getRowNum() > header.getRowNum());

        sheetVisitorForTable.accept(sheet);

        return buildTable(header, table);
    }

    protected void put(R row, C column, Cell cell) {
        table.put(row, column, cell);
    }

    protected SheetVisitor rowsVisitor(RowVisitor cellsRelevantToHeaderVisitor, RowCondition rowCondition) {
        return SheetVisitor.defaultVisitorWithFilter(cellsRelevantToHeaderVisitor, rowCondition);
    }

    /* todo create table from diff methods, see TreeBasedTable.create.. */
    protected abstract Table<R, C, Cell> createPoiTable();

    protected abstract ExcelSubTable<R, C> buildTable(TableHeader<C> tableHeader, Table<R, C, Cell> table);

    protected abstract HeaderConditionalCellVisitor createTableBuilder(TableHeader<C> tableHeader);

    public abstract class HeaderConditionalCellVisitor<C extends Column> implements ConditionalCellVisitor {
        @Getter(value = AccessLevel.PROTECTED)
        private final TableHeader<C> header;

        HeaderConditionalCellVisitor(TableHeader<C> header) {
            this.header = header;
        }

        @Override
        public boolean test(Cell cell) {
            return header.containsIndex(cell.getColumnIndex());
        }
    }
}
