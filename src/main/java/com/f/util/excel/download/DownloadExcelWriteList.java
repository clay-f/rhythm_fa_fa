package com.f.util.excel.download;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * 将所有data写入excel。不包含表头
 * <p>
 * <p>
 * created by f at 2020-12-19 20:02
 *
 * @param <D> 写入excel的数据类型
 */
public interface DownloadExcelWriteList<D> extends DownloadExcel {
    void writeBody(Sheet sheet, List<D> data, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper);
}
