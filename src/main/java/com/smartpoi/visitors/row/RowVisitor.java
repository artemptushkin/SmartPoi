package com.smartpoi.visitors.row;

import org.apache.poi.ss.usermodel.Row;

import java.util.function.Consumer;

public interface RowVisitor extends Consumer<Row> {
}
