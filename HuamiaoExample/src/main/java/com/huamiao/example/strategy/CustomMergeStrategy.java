package com.huamiao.example.strategy;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.huamiao.example.annotation.CustomMerge;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义合并策略〉
 *
 * @author ZZH
 * @create 2022/4/13
 * @since 1.0.0
 */
public class CustomMergeStrategy implements RowWriteHandler {

    private Integer pkIndex;

    private Class<?> elementType;

    private List<Integer> needMergeColumnIndex = new ArrayList<>();

    private int[] rowMergeIndx = new int[]{1,1};

    public CustomMergeStrategy() {
    }

    public CustomMergeStrategy(Class<?> elementType) {
        this.elementType = elementType;
    }



    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        if (isHead) return;

        // 获取当前Sheet
        Sheet sheet = writeSheetHolder.getSheet();

        if (null == pkIndex) this.lazyInit(writeSheetHolder);

        if (row.getRowNum() <= 1) return;

        int[] rowMergeIndex = rowMergeIndx;
        int oldRow1 = rowMergeIndex[0], oldRow2 = rowMergeIndex[1];


        // 获取上一行
        Row lastRow = sheet.getRow(row.getRowNum() - 1);

        if (getCellValue(row.getCell(pkIndex)).equalsIgnoreCase(getCellValue(lastRow.getCell(pkIndex)))){
            rowMergeIndex[1] = row.getRowNum();
        } else {
            rowMergeIndex[0] = row.getRowNum();
        }

        if (rowMergeIndex[0] > rowMergeIndex[1] && oldRow1 < oldRow2){
            needMergeColumnIndex.forEach(needMerIndex -> {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(oldRow1, oldRow2,
                        needMerIndex, needMerIndex);
                sheet.addMergedRegionUnsafe(cellRangeAddress);
            });
        }

    }

    private void lazyInit(WriteSheetHolder writeSheetHolder) {
        // 获取当前sheet
        Sheet sheet = writeSheetHolder.getSheet();

        // 获取标题行
        Row titleRow = sheet.getRow(0);
        // 获取DTO的类型
        Class<?> eleType = this.elementType;
        // 获取标题行单元格数
        int lastCellNum = titleRow.getLastCellNum();

        // 获取DTO所有的属性
        Field[] fields = eleType.getDeclaredFields();

        for (Field field: fields) {

            ExcelProperty excelProperty = field.getDeclaredAnnotation(ExcelProperty.class);
            if (excelProperty == null) continue;

            CustomMerge customMerge = field.getDeclaredAnnotation(CustomMerge.class);

            if (null == customMerge) continue;

            for (int i = 0; i < lastCellNum; i++) {
                Cell cell = titleRow.getCell(i);
                if (excelProperty.value()[0].equals(cell.getStringCellValue())){
                    if (customMerge.isPk()) this.pkIndex = i;
                    if (customMerge.needMerge()) this.needMergeColumnIndex.add(i);
                }
            }

        }

    }

    private static String getCellValue(Cell cell) {
        String resultValue = "";
        // 判空
        if (Objects.isNull(cell)) {
            return resultValue;
        }

        // 拿到单元格类型
        CellType cellType = cell.getCellType();
        switch (cellType) {
            // 字符串类型
            case STRING:
                resultValue = StringUtils.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            // 布尔类型
            case BOOLEAN:
                resultValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 数值类型
            case NUMERIC:
                resultValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                break;
            // 取空串
            default:
                break;
        }
        return resultValue;
    }
}