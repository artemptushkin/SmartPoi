package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.stream.consumer.BetweenChildrenVisitor;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class BetweenCellsRowVisitor extends BetweenChildrenVisitor<Row, Cell> implements RowVisitor {

    public BetweenCellsRowVisitor(CellVisitor cellVisitor,
                                  CellCondition leftCondition,
                                  CellCondition rightCondition,
                                  boolean inclusiveLeft,
                                  boolean inclusiveRight) {
        super(cellVisitor, leftCondition, rightCondition, inclusiveLeft, inclusiveRight);
    }

    public BetweenCellsRowVisitor(CellVisitor cellVisitor,
                                  CellCondition leftCondition,
                                  CellCondition rightCondition) {
        super(cellVisitor, leftCondition, rightCondition);
    }
}
