package com.smartpoi.visitors.sheet;

import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.condition.cell.EqIgnoreCaseCondition;
import com.smartpoi.condition.row.AnyMatchCellRowCondition;
import com.smartpoi.condition.row.RowCondition;
import com.smartpoi.visitors.row.RowVisitor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.smartpoi.excel.ExcelIntegrationTestUtil.createDataFormatter;
import static com.smartpoi.excel.ExcelIntegrationTestUtil.createTestWorkbook;
import static org.hamcrest.MatcherAssert.assertThat;

class BetweenRowsSheetVisitorTest {
    static Workbook workbook;

    SheetVisitor sheetVisitor;

    RowVisitor rowVisitor;
    RowCondition leftCondition;
    RowCondition rightCondition;

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
        rowVisitor = cell -> ++visited;
        CellCondition cellCondition1 = new EqIgnoreCaseCondition("Первая ячейка", createDataFormatter(workbook));
        CellCondition cellCondition2 = new EqIgnoreCaseCondition("Шапка1", createDataFormatter(workbook));
        leftCondition = new AnyMatchCellRowCondition(cellCondition1);
        rightCondition = new AnyMatchCellRowCondition(cellCondition2);
    }

    @Test
    void accept() {
        expectedToVisit = 1;
        sheetVisitor = new BetweenRowsSheetVisitor(rowVisitor, leftCondition, rightCondition);

        sheetVisitor.accept(relevantSheet());

        assertResult();
    }

    @Test
    void acceptWithInclusiveBoth() {
        expectedToVisit = 3;
        sheetVisitor = new BetweenRowsSheetVisitor(rowVisitor, leftCondition, rightCondition, true, true);

        sheetVisitor.accept(relevantSheet());

        assertResult();
    }

    private void assertResult() {
        assertThat(visited, Matchers.equalTo(expectedToVisit));
    }

    private Sheet relevantSheet() {
        return workbook.getSheetAt(0);
    }

}