package com.smartpoi.visitors.workbook;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.function.Consumer;

@FunctionalInterface
public interface WorkbookVisitor extends Consumer<Workbook> {
}
