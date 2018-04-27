package com.smartpoi.excel;

import com.smartpoi.condition.ExcelConditionFactory;
import com.smartpoi.condition.cell.CellCondition;
import com.smartpoi.condition.cell.CellConditionFactory;
import com.smartpoi.condition.row.AnyMatchCellRowCondition;
import com.smartpoi.mapper.column.CellToColumn;
import com.smartpoi.mapper.column.StringCellValueToColumn;
import com.smartpoi.table.ExcelHashTableBuilder;
import com.smartpoi.table.TableBuilder;
import com.smartpoi.table.header.HeaderBuilder;
import com.smartpoi.table.header.NestedTableHeaderBuilder;
import com.smartpoi.table.header.TableHeader;
import com.smartpoi.visitors.row.BetweenCellsRowVisitor;
import com.smartpoi.visitors.row.RowVisitor;
import com.smartpoi.visitors.sheet.SheetVisitor;
import com.smartpoi.visitors.sheet.SingleRowSheetVisitor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainExampleTest {
    private static Workbook workbook;

    @BeforeAll
    public static void setUp() throws Exception {
        InputStream is = Files.newInputStream(Paths.get("src/test/resources/ExcelExample.xlsx"));
        workbook = new XSSFWorkbook(is);
    }

    @Test
    public void someTest() throws Exception {
        CellToColumn cellMapper = new StringCellValueToColumn(new DataFormatter());
        HeaderBuilder headerBuilder = new NestedTableHeaderBuilder(cellMapper);
        CellConditionFactory conditionFactory = new ExcelConditionFactory(workbook.getCreationHelper().createFormulaEvaluator());
        CellCondition fistHeaderCellCondition = conditionFactory.eqIgnoreCaseCondition("Шапка1");
        CellCondition fistHeaderCellCondition2 = conditionFactory.eqIgnoreCaseCondition("Шапка4");
        RowVisitor rowVisitor = new BetweenCellsRowVisitor(headerBuilder, fistHeaderCellCondition, fistHeaderCellCondition2);
        SheetVisitor sheetVisitor = new SingleRowSheetVisitor(new AnyMatchCellRowCondition(fistHeaderCellCondition),
                rowVisitor);
        workbook.forEach(sheetVisitor);
        TableHeader header = headerBuilder.build();

        TableBuilder tableBuilder = new ExcelHashTableBuilder(header);

    }
}
