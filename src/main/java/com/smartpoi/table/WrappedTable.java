package com.smartpoi.table;

import com.google.common.collect.Table;
import lombok.AccessLevel;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class WrappedTable<R, C> implements ExcelSubTable<R, C> {
    @Getter(value = AccessLevel.PROTECTED)
    private final Table<R, C, org.apache.poi.ss.usermodel.Cell> wrappedPoiTable;

    WrappedTable(Table<R, C, org.apache.poi.ss.usermodel.Cell> wrappedPoiTable) {
        this.wrappedPoiTable = wrappedPoiTable;
    }

    @Override
    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        return wrappedPoiTable.contains(rowKey, columnKey);
    }

    @Override
    public boolean containsRow(@Nullable Object rowKey) {
        return wrappedPoiTable.containsRow(rowKey);
    }

    @Override
    public boolean containsColumn(@Nullable Object columnKey) {
        return wrappedPoiTable.containsColumn(columnKey);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return wrappedPoiTable.containsValue(value);
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell get(@Nullable Object rowKey, @Nullable Object columnKey) {
        return wrappedPoiTable.get(rowKey, columnKey);
    }

    @Override
    public boolean isEmpty() {
        return wrappedPoiTable.isEmpty();
    }

    @Override
    public int size() {
        return wrappedPoiTable.size();
    }

    @Override
    public void clear() {
        wrappedPoiTable.clear();
    }

    @Nullable
    @Override
    public org.apache.poi.ss.usermodel.Cell put(R rowKey, C columnKey, org.apache.poi.ss.usermodel.Cell value) {
        return wrappedPoiTable.put(rowKey, columnKey, value);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends org.apache.poi.ss.usermodel.Cell> table) {
        wrappedPoiTable.putAll(table);
    }

    @Nullable
    @Override
    public org.apache.poi.ss.usermodel.Cell remove(@Nullable Object rowKey, @Nullable Object columnKey) {
        return wrappedPoiTable.remove(rowKey, columnKey);
    }

    @Override
    public Map<C, org.apache.poi.ss.usermodel.Cell> row(R rowKey) {
        return wrappedPoiTable.row(rowKey);
    }

    @Override
    public Map<R, org.apache.poi.ss.usermodel.Cell> column(C columnKey) {
        return wrappedPoiTable.column(columnKey);
    }

    @Override
    public Set<Cell<R, C, org.apache.poi.ss.usermodel.Cell>> cellSet() {
        return wrappedPoiTable.cellSet();
    }

    @Override
    public Set<R> rowKeySet() {
        return wrappedPoiTable.rowKeySet();
    }

    @Override
    public Set<C> columnKeySet() {
        return wrappedPoiTable.columnKeySet();
    }

    @Override
    public Collection<org.apache.poi.ss.usermodel.Cell> values() {
        return wrappedPoiTable.values();
    }

    @Override
    public Map<R, Map<C, org.apache.poi.ss.usermodel.Cell>> rowMap() {
        return wrappedPoiTable.rowMap();
    }

    @Override
    public Map<C, Map<R, org.apache.poi.ss.usermodel.Cell>> columnMap() {
        return wrappedPoiTable.columnMap();
    }
}
