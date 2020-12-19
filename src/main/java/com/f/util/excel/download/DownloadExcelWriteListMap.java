package com.f.util.excel.download;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * 下载excel文件接口。
 * <p>
 * 字体使用 {@link com.f.util.ExcelHelper#DEFAULT_FONT font}，size: 12
 * <p>
 * created by f at 2020-12-19 20:02
 *
 * @param <H> 表头数据类型
 * @param <D> 表内容数据类型
 */
public interface DownloadExcelWriteListMap<H, D> extends DownloadExcel {
    /**
     * 写入表头，默认从第一行开始。
     *
     * @param data           表头
     * @param sheet
     * @param cellStyle
     * @param creationHelper
     */
    void writeHeader(List<H> data, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);

    /**
     * 写入表内容，默认从第二行开始。
     * <p>
     * 写入数据的时候，是否需要使用表头根据具体需要实现。
     * 例:
     * <table border="1">
     *    <thead>
     *        <tr><th>name</th><th>sex</th></tr>
     *    </thead>
     *    <tbody>
     *        <tr><td>foo</td><td>1</td></tr>
     *        <tr><td>foo2</td><td>0</td></tr>
     *    </tbody>
     * </table>
     * <p>
     * 表内容的每一行数据需要使用表头作为key。
     * <p>
     * 若表内容的顺序与表头顺序是一致的，可以不使用表头
     *
     * @param header         表头。用于映射表头与表内容字段的关系
     * @param data           内容
     * @param curRowNum      当前行
     * @param sheet
     * @param cellStyle
     * @param creationHelper
     */
    void writeBody(List<H> header, List<D> data, int curRowNum, Sheet sheet, CellStyle cellStyle, CreationHelper creationHelper);
}
