package com.smartpoi.condition.cell;

import lombok.NonNull;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString(of = "pattern")
public class PatternMatchesCondition implements CellCondition {
    private final Pattern pattern;
    private final DataFormatter dataFormatter;

    public PatternMatchesCondition(@NonNull String regexPattern, @NonNull DataFormatter dataFormatter) {
        this.pattern = Pattern.compile(regexPattern);
        this.dataFormatter = dataFormatter;
    }

    @Override
    public boolean test(Cell cell) {
        String cellValue = dataFormatter.formatCellValue(cell);
        Matcher matcher = pattern.matcher(cellValue);
        return matcher.find();
    }
}
