package com.smartpoi.visitors;

public abstract class AbstractExcelVisitor {

    protected boolean foundIndex(int index) {
        return index >= 0;
    }

    protected boolean lookingForIndex(int index) {
        return !foundIndex(index);
    }

    protected boolean startAndEndFound(int startIndex, int endIndex) {
        return foundIndex(startIndex) && foundIndex(endIndex);
    }
}
