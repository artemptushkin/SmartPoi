package com.smartpoi.table.builder;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.header.Column;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.row.RowVisitor;
import com.smartpoi.visitors.sheet.SheetVisitor;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class AbstractTableBuildHandler<R, C extends Column> implements TableBuildHandler<R, C> {

    private final HeaderBuilder headerBuilder;
    private final SheetVisitor headerSheetVisitor;

    public AbstractTableBuildHandler(HeaderBuilder headerBuilder,
                                     SheetVisitor headerSheetVisitor) {
        this.headerBuilder = headerBuilder;
        this.headerSheetVisitor = headerSheetVisitor;
    }

    @Override
    public ExcelSubTable<R, C> buildTable(Sheet sheet) {
        headerSheetVisitor.accept(sheet);
        TableHeader header = headerBuilder.build();
        TableBuilder<R, C> tableBuilder = createTableBuilder(header);

        SheetVisitor sheetVisitorForTable = rowsVisitor(
                RowVisitor.visitorWithFilter(tableBuilder, notHeaderRowCondition(tableBuilder, header)));

        sheetVisitorForTable.accept(sheet);

        return tableBuilder.buildTable();
    }

    protected abstract TableBuilder<R, C> createTableBuilder(TableHeader<C> header);

    protected SheetVisitor rowsVisitor(RowVisitor cellsRelevantToHeaderVisitor) {
        return SheetVisitor.defaultVisitor(cellsRelevantToHeaderVisitor);
    }

    private CellCondition notHeaderRowCondition(TableBuilder<R, C> tableBuilder, TableHeader header) {
        return cell -> tableBuilder.test(cell) && cell.getRowIndex() > header.getRowNum();
    }
}
