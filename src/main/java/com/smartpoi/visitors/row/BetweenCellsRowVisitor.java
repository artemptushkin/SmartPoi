package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.exception.RowRangeNotFound;
import com.smartpoi.visitors.AbstractExcelVisitor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class BetweenCellsRowVisitor extends AbstractExcelVisitor implements RowVisitor {
    private final Consumer<Cell> cellConsumer;
    private final CellCondition firstCellCondition;
    private final CellCondition secondCellCondition;

    public BetweenCellsRowVisitor(Consumer<Cell> cellConsumer,
                                  CellCondition firstCellCondition, CellCondition secondCellCondition) {
        this.cellConsumer = cellConsumer;
        this.firstCellCondition = firstCellCondition;
        this.secondCellCondition = secondCellCondition;
    }

    @Override
    public void accept(Row row) {
        int startIndex = -1;
        int endIndex = -1;
        Iterator<Cell> rowIterator = row.cellIterator();
        while (rowIterator.hasNext() && !startAndEndFound(startIndex, endIndex)) {
            Cell cell = rowIterator.next();

            if (lookingForIndex(startIndex) && firstCellCondition.test(cell)) {
                startIndex = cell.getColumnIndex();
            } else if (foundIndex(startIndex) && secondCellCondition.test(cell)) {
                endIndex = cell.getColumnIndex();
            }
        }

        if (startAndEndFound(startIndex, endIndex)) {
            int finalStartIndex = startIndex;
            int finalEndIndex = endIndex;
            StreamSupport.stream(row.spliterator(), false)
                    .filter(cell -> rowBetweenIndexIncludeLeft(cell, finalStartIndex, finalEndIndex)).forEach(cellConsumer);
        } else {
            throw new RowRangeNotFound(firstCellCondition.toString() + ", " + secondCellCondition.toString());
        }
    }

    private boolean rowBetweenIndexIncludeLeft(Cell cell, final int left, final int right) {
        int rowNum = cell.getColumnIndex();
        return rowNum >= left && rowNum < right;
    }
}
