package com.smartpoi.table;

import com.google.common.collect.Table;
import com.smartpoi.table.header.TableHeader;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Map;
import java.util.function.Predicate;

public interface ExcelSubTable<R, C> extends Table<R, C, Cell> {

    TableHeader<C> getTableHeader();

    int columnSize();
    boolean removeRowsIf(Predicate<R> rowPredicate);
    boolean removeColumnsIf(Predicate<C> columnPredicate);

    Map.Entry<C, org.apache.poi.ss.usermodel.Cell> getCellEntry(Predicate<R> rowPredicate, Predicate<C> columnPredicate);
    Map.Entry<C, Map<R, org.apache.poi.ss.usermodel.Cell>> getColumnEntry(Predicate<C> columnPredicate);
    Map.Entry<R, Map<C, org.apache.poi.ss.usermodel.Cell>> getRowEntry(Predicate<R> rowPredicate);

    org.apache.poi.ss.usermodel.Cell getCell(Predicate<R> rowPredicate, Predicate<C> columnPredicate);
    C getColumn(Predicate<C> columnPredicate);
    R getRow(Predicate<R> rowPredicate);
}
