package com.smartpoi.table;

import com.google.common.collect.Table;
import com.smartpoi.exception.*;
import com.smartpoi.table.header.TableHeader;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class AbstractExcelSubTable<R, C> extends WrappedTable<R, C> {

    @Getter(value = AccessLevel.PUBLIC)
    private final TableHeader tableHeader;

    public AbstractExcelSubTable(TableHeader tableHeader,
                                 Table<R, C, org.apache.poi.ss.usermodel.Cell> table) {
        super(table);
        this.tableHeader = tableHeader;
    }

    @Override
    public int columnSize() {
        return tableHeader.getColumnsSize();
    }

    @Override
    public boolean removeRowsIf(Predicate<R> rowPredicate) {
        return getPoiTable()
                .rowKeySet()
                .removeIf(rowPredicate);
    }

    @Override
    public boolean removeColumnsIf(Predicate<C> columnPredicate) {
        return getPoiTable()
                .columnKeySet()
                .removeIf(columnPredicate);
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell getCell(Predicate<R> rowPredicate, Predicate<C> columnPredicate) {
        return getCellEntry(rowPredicate, columnPredicate)
                .getValue();
    }

    @Override
    public C getColumn(Predicate<C> columnPredicate) {
        return getPoiTable()
                .columnKeySet()
                .stream()
                .filter(columnPredicate)
                .findFirst()
                .orElseThrow(getColumnNotFoundExceptionSupplier(columnPredicate));
    }

    @Override
    public R getRow(Predicate<R> rowPredicate) {
        return getPoiTable()
                .rowKeySet()
                .stream()
                .filter(rowPredicate)
                .findFirst()
                .orElseThrow(getRowNotFoundExceptionSupplier(rowPredicate));
    }

    @Override
    public Map.Entry<C, Map<R, org.apache.poi.ss.usermodel.Cell>> getColumnEntry(Predicate<C> columnPredicate) {
        return getPoiTable()
                .columnMap()
                .entrySet()
                .stream()
                .filter(cMapEntry -> columnPredicate.test(cMapEntry.getKey()))
                .findFirst()
                .orElseThrow(getColumnNotFoundExceptionSupplier(columnPredicate));
    }

    @Override
    public Map.Entry<R, Map<C, org.apache.poi.ss.usermodel.Cell>> getRowEntry(Predicate<R> rowPredicate) {
        return getPoiTable()
                .rowMap()
                .entrySet()
                .stream()
                .filter(rMapEntry -> rowPredicate.test(rMapEntry.getKey()))
                .findFirst()
                .orElseThrow(getRowNotFoundExceptionSupplier(rowPredicate));
    }

    @Override
    public Map.Entry<C, org.apache.poi.ss.usermodel.Cell> getCellEntry(Predicate<R> rowPredicate, Predicate<C> columnPredicate) {
        return getRowEntry(rowPredicate)
                .getValue()
                .entrySet()
                .stream()
                .filter(cellEntry -> columnPredicate.test(cellEntry.getKey()))
                .findFirst()
                .orElseThrow((Supplier<CellVisitException>) () -> new CellNotFoundException(rowPredicate, columnPredicate));
    }

    private Supplier<RowVisitException> getRowNotFoundExceptionSupplier(Predicate<R> rowPredicate) {
        return () -> new RowNotFoundException(rowPredicate);
    }

    private Supplier<ColumnVisitException> getColumnNotFoundExceptionSupplier(Predicate<C> columnPredicate) {
        return () -> new ColumnNotFoundException(columnPredicate);
    }
}
