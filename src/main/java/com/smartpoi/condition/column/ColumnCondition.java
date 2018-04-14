package com.smartpoi.condition.column;

import com.smartpoi.table.header.Column;

import java.util.function.Predicate;

@FunctionalInterface
public interface ColumnCondition extends Predicate<Column> {
}
