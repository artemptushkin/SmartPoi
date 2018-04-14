package com.smartpoi.condition.cell;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.apache.poi.ss.usermodel.DataFormatter;

@Getter
@ToString(of = "expectedValue")
public abstract class CellValueCondition implements CellCondition {
    protected final String expectedValue;
    protected final DataFormatter dataFormatter;

    public CellValueCondition(@NonNull String expectedValue, @NonNull DataFormatter dataFormatter) {
        this.expectedValue = expectedValue;
        this.dataFormatter = dataFormatter;
    }
}
