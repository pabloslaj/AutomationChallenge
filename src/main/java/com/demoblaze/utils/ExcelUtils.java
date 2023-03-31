package com.demoblaze.utils;

import com.demoblaze.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.demoblaze.config.factory.ConfigFactory.getConfig;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = null;
        //FIXME
        // try with resources, para no agregar el finally block puedo usar esto, y si hay o no hay exception se va a cerrar el file input stream
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelPath() + getConfig().excelName())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRowNumber = sheet.getLastRowNum();
            int lastColNumber = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= lastRowNumber; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColNumber; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
