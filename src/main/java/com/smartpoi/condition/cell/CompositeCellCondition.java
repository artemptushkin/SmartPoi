package com.smartpoi.condition.cell;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ToString(of = "conditions")
abstract class CompositeCellCondition implements CellCondition {
    @Getter
    private final List<CellCondition> conditions;

    protected CompositeCellCondition(@NonNull CellCondition... conditions) {
        this.conditions = Arrays.stream(conditions).collect(Collectors.toList());
    }
}
