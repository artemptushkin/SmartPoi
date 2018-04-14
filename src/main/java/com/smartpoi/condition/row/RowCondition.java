package com.smartpoi.condition.row;

import org.apache.poi.ss.usermodel.Row;

import java.util.function.Predicate;

@FunctionalInterface
public interface RowCondition extends Predicate<Row> {
}
