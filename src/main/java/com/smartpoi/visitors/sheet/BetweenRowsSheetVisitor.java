package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.stream.consumer.BetweenChildrenVisitor;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class BetweenRowsSheetVisitor extends BetweenChildrenVisitor<Sheet, Row> implements SheetVisitor {

    public BetweenRowsSheetVisitor(RowVisitor visitor,
                                   RowCondition leftCondition,
                                   RowCondition rightCondition,
                                   boolean inclusiveLeft, boolean inclusiveRight) {
        super(visitor, leftCondition, rightCondition, inclusiveLeft, inclusiveRight);
    }

    public BetweenRowsSheetVisitor(RowVisitor cellVisitor,
                                   RowCondition leftCondition,
                                   RowCondition rightCondition) {
        super(cellVisitor, leftCondition, rightCondition);
    }
}
