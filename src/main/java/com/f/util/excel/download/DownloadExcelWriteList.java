package com.f.util.excel.download;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface DownloadExcelWriteList<D> extends DownloadExcel {
    void writeBody(Sheet sheet, List<D> data, int curRowNum, CellStyle cellStyle, CreationHelper creationHelper);
}
