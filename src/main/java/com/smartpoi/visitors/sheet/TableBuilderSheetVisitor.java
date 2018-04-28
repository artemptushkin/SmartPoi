package com.smartpoi.visitors.sheet;

import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Row;

import java.util.function.Consumer;

public class TableBuilderSheetVisitor implements RowVisitor {
    private final HeaderBuilder headerBuilder;

    public TableBuilderSheetVisitor(HeaderBuilder headerBuilder) {
        this.headerBuilder = headerBuilder;
    }

    @Override
    public void accept(Row cells) {

    }

    @Override
    public RowVisitor andThen(Consumer<? super Row> after) {
        return null;
    }
}
