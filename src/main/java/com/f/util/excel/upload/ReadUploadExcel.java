package com.f.util.excel.upload;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface ReadUploadExcel<R> {
    List<R> readFile(Workbook workbook);
}
