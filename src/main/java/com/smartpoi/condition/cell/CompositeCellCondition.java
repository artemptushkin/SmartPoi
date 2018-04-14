package com.smartpoi.condition.cell;

import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract class CompositeCellCondition implements CellCondition {
    @Getter
    private final List<CellCondition> conditions;

    protected CompositeCellCondition(@NonNull CellCondition... conditions) {
        this.conditions = Arrays.stream(conditions).collect(Collectors.toList());
    }
}
