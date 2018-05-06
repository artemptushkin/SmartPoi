package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.stream.spliterator.SkipWhileSpliterator;
import com.smartpoi.stream.consumer.BetweenChildrenVisitor;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Spliterator;

public class SkipWhileRowVisitor extends BetweenChildrenVisitor<Row, Cell> {

    public SkipWhileRowVisitor(CellVisitor visitor,
                               CellCondition condition) {
        super(visitor, condition, condition.negate(), true, false);
    }

    @Override
    public SkipWhileSpliterator<Cell> buildSpliterator(Spliterator<Cell> source) {
        return new SkipWhileSpliterator<>(source, getLeftCondition());
    }
}
