package com.smartpoi.condition.sheet;

import com.smartpoi.condition.row.RowCondition;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.stream.StreamSupport;

@ToString(of = "rowCondition")
public class AnyMatchRowCondition implements SheetCondition {
    private final RowCondition rowCondition;

    public AnyMatchRowCondition(RowCondition rowCondition) {
        this.rowCondition = rowCondition;
    }

    @Override
    public boolean test(Sheet rows) {
        return StreamSupport.stream(rows.spliterator(), false)
                .anyMatch(rowCondition);
    }
}
