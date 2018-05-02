package com.smartpoi.excel;

import com.smartpoi.util.DataFormatterWrapper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelIntegrationTestUtil {
    private ExcelIntegrationTestUtil(){}

    public static Workbook createTestWorkbook() throws IOException {
        InputStream is = Files.newInputStream(Paths.get("src/test/resources/ExcelExample.xlsx"));
        return new XSSFWorkbook(is);
    }

    public static DataFormatter createDataFormatter(Workbook workbook) {
        return new DataFormatterWrapper(workbook.getCreationHelper().createFormulaEvaluator());
    }
}