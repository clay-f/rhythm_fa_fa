package com.f.util.excel.download;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface DownloadExcelWriteListMap<H, D> extends DownloadExcel {
    void writeHeader(List<H> data, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);

    void writeBody(List<H> header, List<D> data, int curRowNum, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);
}
