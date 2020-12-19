package com.f.util.excel.upload;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * 读取excel文件接口
 * <p>
 * created by f at 2020-12-19 20:02
 *
 * @param <R>
 */
public interface ReadUploadExcel<R> {
    List<R> readFile(Workbook workbook);
}
