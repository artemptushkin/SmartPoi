package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.exception.RowRangeNotFound;
import com.smartpoi.visitors.AbstractExcelVisitor;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;
import java.util.stream.StreamSupport;

public class BetweenRowsSheetVisitor extends AbstractExcelVisitor implements SheetVisitor {

    private final RowVisitor rowVisitor;
    private final RowCondition firstRowCondition;
    private final RowCondition secondRowCondition;

    public BetweenRowsSheetVisitor(RowVisitor rowVisitor,
                                   RowCondition firstRowCondition, RowCondition secondRowCondition) {
        this.rowVisitor = rowVisitor;
        this.firstRowCondition = firstRowCondition;
        this.secondRowCondition = secondRowCondition;
    }

    @Override
    public void accept(Sheet sheet) {
        int startIndex = -1;
        int endIndex = -1;
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext() && !startAndEndFound(startIndex, endIndex)) {
            Row row = rowIterator.next();

            if (lookingForIndex(startIndex) && firstRowCondition.test(row)) {
                startIndex = row.getRowNum();
            } else if (foundIndex(startIndex) && secondRowCondition.test(row)) {
                endIndex = row.getRowNum();
            }
        }

        if (startAndEndFound(startIndex, endIndex)) {
            int finalStartIndex = startIndex;
            int finalEndIndex = endIndex;
            StreamSupport.stream(sheet.spliterator(), false)
                    .filter(row -> rowBetweenIndex(row, finalStartIndex, finalEndIndex)).forEach(rowVisitor);
        } else {
            throw new RowRangeNotFound(firstRowCondition.toString() + ", " + secondRowCondition.toString());
        }
    }

    private boolean rowBetweenIndex(Row row, final int left, final int right) {
        int rowNum = row.getRowNum();
        return rowNum > left && rowNum < right;
    }

}
