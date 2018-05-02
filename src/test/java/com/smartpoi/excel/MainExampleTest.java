package com.smartpoi.excel;

import com.smartpoi.condition.ExcelConditionFactory;
import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.condition.cell.CellConditionFactory;
import com.smartpoi.condition.row.AnyMatchCellRowCondition;
import com.smartpoi.mapper.cell.CellMapper;
import com.smartpoi.mapper.cell.CellToStringMapper;
import com.smartpoi.table.ExcelSubTable;
import com.smartpoi.table.builder.HashTableBuilder;
import com.smartpoi.table.builder.TableBuilder;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.NestedTableHeaderBuilder;
import com.smartpoi.visitors.row.BetweenCellsRowVisitor;
import com.smartpoi.visitors.row.RowVisitor;
import com.smartpoi.visitors.sheet.SheetVisitor;
import com.smartpoi.visitors.sheet.SingleRowSheetVisitor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.smartpoi.excel.ExcelIntegrationTestUtil.createDataFormatter;
import static com.smartpoi.excel.ExcelIntegrationTestUtil.createTestWorkbook;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MainExampleTest {
    private static Workbook workbook;
    private static DataFormatter dataFormatter;

    @BeforeAll
    static void setUp() throws Exception {
        workbook = createTestWorkbook();
        dataFormatter = createDataFormatter(workbook);
    }

    @Test
    void someTest() throws Exception {
        CellMapper<String> cellMapper = new CellToStringMapper(new DataFormatter());
        HeaderBuilder<String> headerBuilder = new NestedTableHeaderBuilder<>(cellMapper);
        CellConditionFactory conditionFactory = new ExcelConditionFactory(workbook.getCreationHelper().createFormulaEvaluator());
        CellCondition fistHeaderCellCondition = conditionFactory.eqIgnoreCase("Шапка1");
        CellCondition fistHeaderCellCondition2 = conditionFactory.eqIgnoreCase("Шапка4");
        RowVisitor rowVisitor = new BetweenCellsRowVisitor(headerBuilder, fistHeaderCellCondition, fistHeaderCellCondition2);
        SheetVisitor sheetVisitor = new SingleRowSheetVisitor(new AnyMatchCellRowCondition(fistHeaderCellCondition),
                rowVisitor);

        TableBuilder<String, String> buildHandler =
                new HashTableBuilder<>(headerBuilder, sheetVisitor, new CellToStringMapper(dataFormatter));

        ExcelSubTable subTable = buildHandler.buildTable(workbook.getSheetAt(0));

        assertThat(subTable.size(), equalTo(4));
    }
}
