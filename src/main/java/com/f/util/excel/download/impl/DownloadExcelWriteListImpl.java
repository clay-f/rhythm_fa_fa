package com.f.util.excel.download.impl;

import com.f.util.ExcelHelper;
import com.f.util.excel.download.DownloadExcelWriteList;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * 将所有数据写入excel。不写入表头。
 * <p>
 * created by f at 2020-12-19 20:02
 */
public class DownloadExcelWriteListImpl implements DownloadExcelWriteList<List<String>> {
    @Override
    public void writeBody(Sheet sheet, List<List<String>> data, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper) {
        ExcelHelper.writeBody(data, sheet, curRowNum, cellStyle, creationHelper);
    }
}
