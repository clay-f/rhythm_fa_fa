package com.f.util;

import com.google.common.collect.Lists;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static java.util.Objects.requireNonNull;

/**
 * 读写excel。提供了两种类型的方法1:读写文件 2:上传下载文件
 * <p>
 * created by f at 2020-12-19 13:34
 */
public class ExcelHelper {
    public static final String  DEFAULT_FONT = "Mac OS X".equals(System.getProperty("os.name")) ? "SFNSMono" : "Microsoft YaHei UI";

    /**
     * 读取excel文件，返回 list.
     * <p>
     * 返回的类型为
     * <pre>
     *     {@code
     *
     * List<Map<String, String>>
     *     }
     * </pre>
     * <p>
     * list每个map都代表一个对象.
     * <p>
     * 假设excel文件第一行是表头
     * 读取逻辑:
     * 首先读取表头
     *
     * @param excelFile excel file
     * @return list
     */
    public static List<Map<String, String>> readExcelAsMap(File excelFile) {
        requireNonNull(excelFile);
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
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        return resultListMap;
    }

    private static Map<Integer, String> getExcelRowValueToMap(Row row) {
        Map<Integer, String> columnMap = new HashMap<>();
        for (Cell item : row)
            columnMap.put(item.getColumnIndex(), item.getStringCellValue());
        return columnMap;
    }

    private static Map<String, String> convertRowToMap(Map<Integer, String> columnMap, Row row) {
        Map<String, String> rowMap = new HashMap<>();
        for (Cell item : row)
            rowMap.put(columnMap.get(item.getColumnIndex()), readCellValue(item));
        return rowMap;
    }

    /**
     * 读取 excel 文件为 list
     * <p>
     * <p>
     * 使用场景: 单纯的把excel全部转化为list，没有表头之分
     *
     * @param file excel 文件
     * @return list
     */
    public static List<List<String>> readExcelAsList(File file) {
        List<List<String>> result = Lists.newArrayList();
        try (Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row item : sheet)
                result.add(readRow(item));
        } catch (IOException e) {
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

    private static String readCellValue(Cell cell) {
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
     * @param file excel文件
     */
    public static void writeExcelWithHeader(List<Map<String, String>> data, File file) {
        requireNonNull(data);
        writeExcelWithHeader(data, convertMapToHeader(data.get(0)), file);
    }

    private static List<String> convertMapToHeader(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> item : map.entrySet())
            list.add(item.getKey());
        return list;
    }

    /**
     * 以 header 为头，data 为数据写入 excel.
     *
     * <p>
     * 写数据的时候，使用header 作为key取数据 map 里面的值，头部可以自定义
     *
     * @param data
     * @param header excel header，头部可以自定义
     * @param file
     */
    public static void writeExcelWithHeader(List<Map<String, String>> data, List<String> header, File file) {
        requireNonNull(data);
        requireNonNull(header);
        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        CellStyle cellStyle = getCellStyleConfig(workbook);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            writeHeader(header, sheet.createRow(0), creationHelper, cellStyle);
            writeBody(data, header, sheet.getLastRowNum() + 1, sheet, creationHelper, cellStyle);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CellStyle getCellStyleConfig(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontName(DEFAULT_FONT);
        font.setFontHeightInPoints((short) 12);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        return cellStyle;
    }

    private static void writeHeader(List<String> header, Row row, CreationHelper creationHelper, CellStyle cellStyle) {
        Cell cell;
        for (int i = 0; i < header.size(); i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(creationHelper.createRichTextString(header.get(i).strip()));
        }
    }

    private static void writeBody(List<Map<String, String>> data, List<String> headers, int currentRow, Sheet sheet, CreationHelper creationHelper, CellStyle cellStyle) {
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


    /**
     * 写入所有的list到excel，不包含表头。
     *
     * @param file excel
     * @param data 数据data
     */
    private static void writeExcelWithList(File file, List<List<String>> data) {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        CellStyle cellStyle = getCellStyleConfig(workbook);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            writeBody(data, sheet, sheet.getLastRowNum() + 1, cellStyle, creationHelper);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBody(List<List<String>> data, Sheet sheet, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper) {
        Cell cell;
        Row row;
        List<String> rowVal;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(i + curRowNum);
            rowVal = data.get(i);
            for (int j = 0; j < rowVal.size(); j++) {
                cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(creationHelper.createRichTextString(rowVal.get(j)));
            }
        }
    }

    /**
     * 下载文件。
     * <p>
     * 使用方法，首先确定要写入的数据类型是什么，然后初始化写Excel的类，表头可以自定义
     *
     * <pre>
     * {@code
     *
     *  // 初始化写入数据实例
     *  WriteServletRequestExcelWithKeyAsHeaderImpl t = new WriteServletRequestExcelWithKeyAsHeaderImpl();
     *
     *  // service 获取要写入的数据
     *  List<Map<String, String>> data = service.getData();
     *
     *  // 从第一个data获取表头
     *  List<String> header = getHeader(data.get(0));
     *
     *  //写入数据并下载
     *  writeHttpServletRequestExcel(t, data, header, response)
     * }
     *
     * </pre>
     *
     * @param t        向excel写数据实现类
     * @param headers  表头
     * @param data     被写入的数据
     * @param response response
     * @param <T>      实现类类型
     * @param <H>      表头类型
     * @param <D>      内容类型
     */
    public static <T extends WriteServletRequestExcel, H, D> void writeHttpServletRequestExcel(T t, List<H> headers, List<D> data, HttpServletResponse response) {
        Workbook workbook = new XSSFWorkbook();
        CellStyle cellStyle = getCellStyleConfig(workbook);
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        response.reset();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("content-disposition", "attachment; filename=data.xlsx");
        try (OutputStream outputStream = response.getOutputStream()) {
            if (t instanceof WriteServletRequestExcelListData) {
                ((WriteServletRequestExcelListData<D>) t).writeBody(sheet, data, sheet.getLastRowNum(), cellStyle, creationHelper);
            } else if (t instanceof WriteServletRequestExcelWithHeader) {
                ((WriteServletRequestExcelWithHeader<H, D>) t).writeHeader(headers, sheet, cellStyle, creationHelper);
                //表头占用了一行，所以写内容的时候要+1
                ((WriteServletRequestExcelWithHeader<H, D>) t).writeBody(headers, data, sheet.getLastRowNum() + 1, sheet, cellStyle, creationHelper);
            }
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface WriteServletRequestExcel {
    }

    public interface WriteServletRequestExcelListData<D> extends WriteServletRequestExcel {
        void writeBody(Sheet sheet, List<D> data, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper);
    }

    public interface WriteServletRequestExcelWithHeader<H, D> extends WriteServletRequestExcel {
        void writeHeader(List<H> data, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);

        void writeBody(List<H> header, List<D> data, int curRowNum, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);
    }


    /**
     * 将所有数据写入excel。不写入表头
     */
    public static class WriteServletRequestExcelListImpl implements WriteServletRequestExcelListData<List<String>> {
        @Override
        public void writeBody(Sheet sheet, List<List<String>> data, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper) {
            ExcelHelper.writeBody(data, sheet, curRowNum, cellStyle, creationHelper);
        }
    }

    /**
     * 表头的顺序与内容无关，表头有一个key，在内容里面用户get value
     * 例如: 表头name, age，内容 getKey(name), getKey(age)
     * <p>
     * <p>
     * Pair left为key，用于从data获取数据，value用于写入excel作为表头
     */
    public static class WriteServletRequestExcelWithKeyAsHeaderImpl implements WriteServletRequestExcelWithHeader<Pair<String, String>, Map<String, String>> {
        @Override
        public void writeHeader(List<Pair<String, String>> data, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper) {
            Row row = sheet.createRow(0);
            List<String> header = Lists.newArrayListWithCapacity(data.size());
            for (Pair<String, String> item : data)
                header.add(item.getValue());
            ExcelHelper.writeHeader(header, row, creationHelper, cellStyle);
        }

        @Override
        public void writeBody(List<Pair<String, String>> header, List<Map<String, String>> data, int curRowNum, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper) {
            List<String> tmpHeaders = Lists.newArrayListWithCapacity(data.size());
            for (Pair<String, String> item : header)
                tmpHeaders.add(item.getValue());
            ExcelHelper.writeBody(data, tmpHeaders, curRowNum, sheet, creationHelper, cellStyle);
        }
    }
}
