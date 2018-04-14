package com.smartpoi.condition;

import com.smartpoi.util.DataFormatterWrapper;
import com.smartpoi.condition.cell.*;
import com.smartpoi.condition.row.AnyMatchCellRowCondition;
import com.smartpoi.condition.row.RowConditionFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class ExcelConditionFactory implements CellConditionFactory, RowConditionFactory {

    private final DataFormatter dataFormatter;

    public ExcelConditionFactory(FormulaEvaluator formulaEvaluator) {
        this.dataFormatter = new DataFormatterWrapper(formulaEvaluator);
    }

    @Override
    public EqIgnoreCaseCondition eqIgnoreCaseCondition(String expectedValue) {
        return new EqIgnoreCaseCondition(expectedValue, dataFormatter);
    }

    @Override
    public AnyMatchCellRowCondition anyMatchCellRowCondition(CellCondition firstRowCellCondition) {
        return new AnyMatchCellRowCondition(firstRowCellCondition);
    }

    @Override
    public ContainsIgnoreCaseCondition containsIgnoreCaseCondition(String checkedValue) {
        return new ContainsIgnoreCaseCondition(checkedValue, dataFormatter);
    }

    @Override
    public EmptyCellCondition emptyCellCondition() {
        return new EmptyCellCondition();
    }

    @Override
    public ColumnIndexCondition columnIndexCondition(int columnIndex) {
        return new ColumnIndexCondition(columnIndex);
    }

    @Override
    public CellCondition anyMatchCompositeCellCondition(CellCondition... conditions) {
        return new AnyMatchCompositeCellCondition(conditions);
    }
}
