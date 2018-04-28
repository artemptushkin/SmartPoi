package com.smartpoi.visitors.row;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.condition.cell.EqIgnoreCaseCondition;
import com.smartpoi.visitors.cell.CellVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.smartpoi.excel.ExcelIntegrationTestUtil.createDataFormatter;
import static com.smartpoi.excel.ExcelIntegrationTestUtil.createTestWorkbook;
import static org.hamcrest.MatcherAssert.assertThat;

class BetweenCellsRowVisitorTest {
    static Workbook workbook;

    RowVisitor rowVisitor;

    CellVisitor cellVisitor;
    CellCondition leftCondition;
    CellCondition rightCondition;

    private int expectedToVisit;
    private int visited;

    @BeforeAll
    static void setUp() throws Exception {
        workbook = createTestWorkbook();
    }

    @BeforeEach
    void setUpEach() throws Exception {
        expectedToVisit = 0;
        visited = 0;
        cellVisitor = cell -> ++visited;
        leftCondition = new EqIgnoreCaseCondition("Шапка1", createDataFormatter(workbook));
        rightCondition = new EqIgnoreCaseCondition("Шапка4", createDataFormatter(workbook));
    }

    @Test
    void accept() {
        expectedToVisit = 2;
        rowVisitor = new BetweenCellsRowVisitor(cellVisitor, leftCondition, rightCondition);

        rowVisitor.accept(relevantRow());

        assertResult();
    }

    @Test
    void acceptWithInclusiveBoth() {
        expectedToVisit = 4;
        rowVisitor = new BetweenCellsRowVisitor(cellVisitor, leftCondition, rightCondition, true, true);

        rowVisitor.accept(relevantRow());

        assertResult();
    }

    private void assertResult() {
        assertThat(visited, Matchers.equalTo(expectedToVisit));
    }

    private Row relevantRow() {
        return workbook.getSheetAt(0).getRow(5);
    }

}