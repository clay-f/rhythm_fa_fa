package com.f.util;

import com.f.util.excel.download.DownloadExcel;
import com.f.util.excel.download.DownloadExcelWriteList;
import com.f.util.excel.download.DownloadExcelWriteListMap;
import com.f.util.excel.upload.ReadUploadExcel;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;

import static java.util.Objects.requireNonNull;

/**
 * 读写excel。提供了两种类型的方法1:读写文件 2:上传下载文件
 * <p>
 * 直接读写文件，调用静态方法。上传下载文件，需要额外使用对应的类
 * <p>
 * created by f at 2020-12-19 13:34
 */
public class ExcelHelper {
    /**
     * 写入文件使用默认字体。
     */
    public static final String DEFAULT_FONT = "Mac OS X".equals(System.getProperty("os.name")) ? "SFNSMono" : "Microsoft YaHei UI";
    public static final int DEFAULT_FONT_SIZE = 12;

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
        List<List<String>> result = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(file)) {
            readSheet(workbook.getSheetAt(0), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void readSheet(Sheet sheet, List<List<String>> result) {
        for (Row item : sheet)
            result.add(readRow(item));
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
     * @param data 要写入的数据
     * @param header excel header，头部可以自定义
     * @param file 输入文件
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
        font.setFontHeightInPoints((short) DEFAULT_FONT_SIZE);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        return cellStyle;
    }

    public static void writeHeader(List<String> header, Row row, CreationHelper creationHelper, CellStyle cellStyle) {
        Cell cell;
        for (int i = 0; i < header.size(); i++) {
            cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(creationHelper.createRichTextString(header.get(i).strip()));
        }
    }

    public static void writeBody(List<Map<String, String>> data, List<String> headers, int currentRow, Sheet sheet, CreationHelper creationHelper, CellStyle cellStyle) {
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
    public static void writeExcelWithList(File file, List<List<String>> data) {
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

    public static void writeBody(List<List<String>> data, Sheet sheet, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper) {
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
     * 使用方法，首先确定要写入的数据结构是什么，然后查看已有实现是否能够满足要求，
     * <ol>
     *     目前有两种实现
     *     <li>
     *         {@link com.f.util.excel.download.impl.DownloadExcelWriteListImpl 单纯写list}。就是将所有list写入表格
     *     </li>
     *     <li>{@link com.f.util.excel.download.impl.DownloadExcelWriteListImpl 带表头写入list}。写入表头，再写入具体内容</li>
     * </ol>
     * <p>
     * 若能满足要求，直接使用默认的就行。若导出的数据结构当前实现不能满足要求，可实现{@link DownloadExcelWriteList 写入list} 或 {@link DownloadExcelWriteListMap 带表头的list}，手动写入数据。
     * <br/>
     * 使用示例:
     * <br/>
     * 首先确认要用哪种实现类，写入数据，然后调用静态方法就行
     * <pre>
     * {@code
     *
     *  // 初始化写入数据实例，用于写入数据的实现类。
     *  WriteServletRequestExcelWithKeyAsHeaderImpl t = new WriteServletRequestExcelWithKeyAsHeaderImpl();
     *
     *  // service 获取要写入的数据
     *  List<Map<String, String>> data = service.getData();
     *
     *  // 从第一个data获取表头。表头通常是从数据里面得到的，所以这里取第一条数据的属性作为表头。表头也可以自定义，自定义表头，自定义导出结果
     *  List<String> header = getHeader(data.get(0));
     *
     *  //写入数据并下载
     *  writeHttpServletRequestExcel(t, data, header, response)
     * }
     *
     * </pre>
     *
     * @param t        写数据实现类对象
     * @param headers  表头
     * @param data     表内容
     * @param response response
     * @param <T>      实现类类型
     * @param <H>      表头类型
     * @param <D>      表内容类型
     */
    public static <T extends DownloadExcel, H, D> void writeDownloadExcel(T t, List<H> headers, List<D> data, HttpServletResponse response) {
        Objects.requireNonNull(t);
        Objects.requireNonNull(data);
        Workbook workbook = new XSSFWorkbook();
        CellStyle cellStyle = getCellStyleConfig(workbook);
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet();
        response.reset();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("content-disposition", "attachment; filename=data.xlsx");
        try (OutputStream outputStream = response.getOutputStream()) {
            if (t instanceof DownloadExcelWriteList) {
                ((DownloadExcelWriteList<D>) t).writeBody(sheet, data, sheet.getLastRowNum(), cellStyle, creationHelper);
            } else if (t instanceof DownloadExcelWriteListMap) {
                ((DownloadExcelWriteListMap<H, D>) t).writeHeader(headers, sheet, cellStyle, creationHelper);
                //表头占用了一行，所以写内容的时候要+1
                ((DownloadExcelWriteListMap<H, D>) t).writeBody(headers, data, sheet.getLastRowNum() + 1, sheet, cellStyle, creationHelper);
            }
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取上传excel文件。
     * <p>
     * 获取文件输入流，使用不同的读取实现类获取不同的数据
     *
     * @param t           读取文件实例
     * @param inputStream 输入流
     * @param <T>         读取文件类型
     * @param <R>         返回值类型
     * @return R 返回值
     */
    public static <T extends ReadUploadExcel<R>, R> R readUploadExcel(T t, InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        Objects.requireNonNull(t);
        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            return (R) t.readFile(workbook);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InvalidParameterException("read excel error");
    }
}
