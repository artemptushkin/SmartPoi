package com.smartpoi.condition.cell;

import org.apache.poi.ss.usermodel.Cell;

import java.util.function.Predicate;

public interface CellCondition extends Predicate<Cell> {
}
