package com.f.util.excel.download.impl;

import com.f.util.ExcelHelper;
import com.f.util.excel.download.DownloadExcelWriteListMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;


/**
 * 表头的顺序与内容无关，表头有一个key，在内容里面用户get value
 * 例如: 表头name, age，内容 getKey(name), getKey(age)
 * <p>
 * <p>
 * Pair left为key，用于从data获取数据，value用于写入excel作为表头
 * <p>
 * created by f at 2020-12-19 20:02
 */
public class DownloadExcelWriteListMapImpl implements DownloadExcelWriteListMap<Pair<String, String>, Map<String, String>> {
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
            tmpHeaders.add(item.getKey());
        ExcelHelper.writeBody(data, tmpHeaders, curRowNum, sheet, creationHelper, cellStyle);
    }
}
