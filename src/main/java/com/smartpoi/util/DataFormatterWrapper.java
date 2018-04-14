package com.smartpoi.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class DataFormatterWrapper extends DataFormatter {
    private final FormulaEvaluator formulaEvaluator;

    public DataFormatterWrapper(FormulaEvaluator formulaEvaluator) {
        this.formulaEvaluator = formulaEvaluator;
    }

    @Override
    public String formatCellValue(Cell cell) {
        return super.formatCellValue(cell, this.formulaEvaluator);
    }
}
