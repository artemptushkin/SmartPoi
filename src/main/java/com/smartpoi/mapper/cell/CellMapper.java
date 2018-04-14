package com.smartpoi.mapper.cell;

import org.apache.poi.ss.usermodel.Cell;

import java.util.function.Function;

@FunctionalInterface
public interface CellMapper<T> extends Function<Cell, T> {
}
