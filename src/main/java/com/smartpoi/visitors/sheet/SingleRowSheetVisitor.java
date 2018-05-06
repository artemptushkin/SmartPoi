package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.exception.RowNotFoundException;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Optional;
import java.util.stream.StreamSupport;

public class SingleRowSheetVisitor implements SheetVisitor {
    private final RowCondition rowCondition;
    private final RowVisitor rowVisitor;
    private final long skipAfterCondition;

    public SingleRowSheetVisitor(RowCondition rowCondition, RowVisitor rowVisitor, long skipAfterCondition) {
        this.skipAfterCondition = skipAfterCondition;
        this.rowCondition = rowCondition;
        this.rowVisitor = rowVisitor;
    }

    public SingleRowSheetVisitor(RowCondition rowCondition, RowVisitor rowVisitor) {
        this.skipAfterCondition = -1L;
        this.rowCondition = rowCondition;
        this.rowVisitor = rowVisitor;
    }

    @Override
    public void accept(Sheet sheet) {
        Optional<Row> optionalRow = StreamSupport.stream(sheet.spliterator(), false)
                .filter(rowCondition).findFirst();
        if (optionalRow.isPresent()) {
            Row row = optionalRow.get();
            if (skipAfterCondition > 0) {
                row = sheet.getRow((int) (row.getRowNum() + skipAfterCondition));
            }
            rowVisitor.accept(row);
        } else {
            throw new RowNotFoundException(rowCondition);
        }
    }
}
