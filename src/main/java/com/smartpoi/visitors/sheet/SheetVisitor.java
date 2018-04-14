package com.smartpoi.visitors.sheet;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.function.Consumer;

@FunctionalInterface
public interface SheetVisitor extends Consumer<Sheet> {
}
