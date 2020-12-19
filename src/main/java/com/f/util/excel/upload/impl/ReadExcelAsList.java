package com.f.util.excel.upload.impl;

import com.f.util.ExcelHelper;
import com.f.util.excel.upload.ReadUploadExcel;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * 读取上传excel为 list
 */
public class ReadExcelAsList implements ReadUploadExcel<List<String>> {
    @Override
    public List<List<String>> readFile(Workbook workbook) {
        List<List<String>> result = Lists.newArrayList();
        ExcelHelper.readSheet(workbook.getSheetAt(0), result);
        return result;
    }
}
