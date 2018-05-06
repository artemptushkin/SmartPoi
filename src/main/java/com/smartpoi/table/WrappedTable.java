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
    private final Table<R, C, org.apache.poi.ss.usermodel.Cell> poiTable;

    WrappedTable(Table<R, C, org.apache.poi.ss.usermodel.Cell> poiTable) {
        this.poiTable = poiTable;
    }

    @Override
    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        return poiTable.contains(rowKey, columnKey);
    }

    @Override
    public boolean containsRow(@Nullable Object rowKey) {
        return poiTable.containsRow(rowKey);
    }

    @Override
    public boolean containsColumn(@Nullable Object columnKey) {
        return poiTable.containsColumn(columnKey);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return poiTable.containsValue(value);
    }

    @Override
    public org.apache.poi.ss.usermodel.Cell get(@Nullable Object rowKey, @Nullable Object columnKey) {
        return poiTable.get(rowKey, columnKey);
    }

    @Override
    public boolean isEmpty() {
        return poiTable.isEmpty();
    }

    @Override
    public int size() {
        return poiTable.size();
    }

    @Override
    public void clear() {
        poiTable.clear();
    }

    @Nullable
    @Override
    public org.apache.poi.ss.usermodel.Cell put(R rowKey, C columnKey, org.apache.poi.ss.usermodel.Cell value) {
        return poiTable.put(rowKey, columnKey, value);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends org.apache.poi.ss.usermodel.Cell> table) {
        poiTable.putAll(table);
    }

    @Nullable
    @Override
    public org.apache.poi.ss.usermodel.Cell remove(@Nullable Object rowKey, @Nullable Object columnKey) {
        return poiTable.remove(rowKey, columnKey);
    }

    @Override
    public Map<C, org.apache.poi.ss.usermodel.Cell> row(R rowKey) {
        return poiTable.row(rowKey);
    }

    @Override
    public Map<R, org.apache.poi.ss.usermodel.Cell> column(C columnKey) {
        return poiTable.column(columnKey);
    }

    @Override
    public Set<Cell<R, C, org.apache.poi.ss.usermodel.Cell>> cellSet() {
        return poiTable.cellSet();
    }

    @Override
    public Set<R> rowKeySet() {
        return poiTable.rowKeySet();
    }

    @Override
    public Set<C> columnKeySet() {
        return poiTable.columnKeySet();
    }

    @Override
    public Collection<org.apache.poi.ss.usermodel.Cell> values() {
        return poiTable.values();
    }

    @Override
    public Map<R, Map<C, org.apache.poi.ss.usermodel.Cell>> rowMap() {
        return poiTable.rowMap();
    }

    @Override
    public Map<C, Map<R, org.apache.poi.ss.usermodel.Cell>> columnMap() {
        return poiTable.columnMap();
    }
}
