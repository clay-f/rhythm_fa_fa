package com.f.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static java.util.Objects.requireNonNull;

public class ExcelHelper {
    private static final String DEFAULT_WIN_FONT = "Microsoft YaHei UI";
    /**
     * 读取excel文件，返回 list.
     *
     * @param excelFile excel file
     * @return list
     */
    public static List<Map<String, String>> readExcelAsMap(File excelFile) {
        List<Map<String, String>> resultListMap = new ArrayList<>();
        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excelFile)) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            Map<Integer, String> columnMap = null;
            for (Iterator<Row> iterator = xssfSheet.iterator(); iterator.hasNext(); ) {
                Row row = iterator.next();
                if (row.getRowNum() == 0)
                    columnMap = getExcelRowValueToMap(row);
                else
                    resultListMap.add(convertRowToMap(columnMap, row));
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultListMap;
    }

    private static Map<Integer, String> getExcelRowValueToMap(Row row) {
        Map<Integer, String> columnMap = new HashMap<>();
        for (Iterator<Cell> cellIterator = row.cellIterator(); cellIterator.hasNext(); ) {
            Cell cell = cellIterator.next();
            columnMap.put(cell.getColumnIndex(), cell.getStringCellValue());
        }
        return columnMap;
    }

    private static Map<String, String> convertRowToMap(Map<Integer, String> columnMap, Row row) {
        Map<String, String> rowMap = new HashMap<>();
        for (Iterator<Cell> cellIterator = row.cellIterator(); cellIterator.hasNext(); ) {
            Cell cell = cellIterator.next(); 
            rowMap.put(columnMap.get(cell.getColumnIndex()), readCellValue(cell));
        }
        return rowMap;
    }
    
    /**
     * 读取 excel 文件为 list
     * <p>
     *
     * @param file excel 文件
     * @return list
    */
    public static List<List<String>> readExcel(File file) {
        List<List<String>> result = Lists.newArrayList();
        try (Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row item : sheet)
                result.add(readRow(item));
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private static List<String> readRow(Row row) {
        List<String> rowVal = new ArrayList<>();
        for (Cell item : row)
            rowVal.add(readCellValue(item));
        return rowVal;
    }
    
    private String readCellValue(Cell cell) {
        String cellValue = null;
       switch (cell.getCellType()) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue().toString();
                } else {
                    cellValue = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BLANK:
                cellValue = "";
                break;
            case BOOLEAN:
                cellValue = Boolean.toString(cell.getBooleanCellValue());
                break;
        }
        return cellValue;
    }

    /**
     * 把 list 写入 excel.
     *
     * @param data list
     * @param file
     */
    public static void writeExcel(List<Map<String, String>> data, File file) {
        requireNonNull(data);
        writeExcel(data, convertMapToHeader(data.get(0)), file);
    }

    private static List<String> convertMapToHeader(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> item : map.entrySet()) {
            list.add(item.getKey());
        }
        return list;
    }

    /**
     * 以 header 为头，data 为数据写入 excel.
     *
     * @param data
     * @param header excel head
     * @param file
     */
    public static void writeExcel(List<Map<String, String>> data, List<String> header, File file) {
        requireNonNull(data);
        requireNonNull(header);
        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        Font font = workbook.createFont();
        font.setFontName("Helvetica Neue");
        font.setFontHeightInPoints((short) 14);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            writeHeader(header, sheet.createRow(0), creationHelper, cellStyle);
            writeBody(data, header, sheet, sheet.getLastRowNum() + 1, creationHelper, cellStyle);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHeader(List<String> header, Row row, CreationHelper creationHelper, CellStyle cellStyle) {
        Cell cell;
        for (int i = 0; i < header.size(); i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(creationHelper.createRichTextString(header.get(i).strip()));
        }
    }

    private static void writeBody(List<Map<String, String>> data, List<String> headers, Sheet sheet, int currentRow, CreationHelper creationHelper, CellStyle cellStyle) {
        Cell cell;
        Row row;
        Map<String, String> rowVal;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(i + currentRow);
            rowVal = data.get(i);
            for (int j = 0; j < headers.size(); j++) {
                cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(creationHelper.createRichTextString(rowVal.get(headers.get(j))));
            }
        }
    }
    
    public static void writeExcelWithWinFont(File file, List<List<String>> data) {
        writeExcel(file, data, DEFAULT_WIN_FONT);
    }


    private static void writeExcel(File file, List<List<String>> data, String fontName) {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        Font font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints((short) 12);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            writeBody(data, sheet, cellStyle, creationHelper);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBody(List<List<String>> data, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper) {
        Cell cell;
        Row row;
        List<String> rowVal;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(i);
            rowVal = data.get(i);
            for (int j = 0; j < rowVal.size(); j++) {
                cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(creationHelper.createRichTextString(rowVal.get(j)));
            }
        }
    }
    
}
