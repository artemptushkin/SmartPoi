package com.smartpoi.visitors.cell;

import org.apache.poi.ss.usermodel.Cell;

import java.util.function.Consumer;

@FunctionalInterface
public interface CellVisitor extends Consumer<Cell> {
}
