package com.example.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;


/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/1/29 11:01
 * @version:1.0
 */
@Slf4j
@Component
public class ExcelHelper {


    public <T> String exportExcel(List<T> retList, String attachPrefixName, String sheetName , Class<T> clz) {
        String fileName = attachPrefixName + "-" + System.currentTimeMillis() + ".xlsx";
        //头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);
        //内容的策略
        WriteCellStyle cellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        //字体大小
        contentWriteFont.setFontHeightInPoints((short) 12);
        cellStyle.setWriteFont(contentWriteFont);
        HorizontalCellStyleStrategy strategy = new HorizontalCellStyleStrategy(headWriteCellStyle, cellStyle);
        // 输出到文件
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            EasyExcel.write(outputStream, clz)
                    .registerWriteHandler(strategy)
                    .sheet(sheetName)
                    .doWrite(retList);
            byte[] bytes = outputStream.toByteArray();
        } catch (Exception e) {
            log.warn("upload file to filegw error", e);
        }
        return null;
    }

    public String writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName,
                             String sheetName, Class model) throws Exception {
        // 下面这行注释的原因是业务 去掉xlsx 要是不去掉会有两个 因为下面的方面已经封装了
//        String fileNameResult = fileName + "-" + System.currentTimeMillis() + ".xlsx";
        String fileNameResult = fileName + "-" + System.currentTimeMillis() ;
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 颜色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        headWriteFont.setFontHeightInPoints((short) 12);
        // 字体
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);
        headWriteCellStyle.setWrapped(true);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠中对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(getOutputStream(fileNameResult, response), model).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy)
                //最大长度自适应 目前没有对应算法优化 建议注释掉不用 会出bug
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(data);
        return fileNameResult;
    }

    /**
     * 导出文件时为Writer生成OutputStream.
     *
     * @param fileName 文件名
     * @param response response
     * @return ""
     */
    private OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {
            throw new Exception("导出excel表格失败", e);
        }
    }
}
