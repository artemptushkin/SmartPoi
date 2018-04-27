package com.smartpoi.condition.sheet;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.function.Predicate;

@FunctionalInterface
public interface SheetCondition extends Predicate<Sheet> {
}
