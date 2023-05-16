package com.huamiao.example.enums.excel;


import lombok.Getter;

@Getter
public enum ExcelPageEnum {
    XLS(10_000, 60_000),
    XLSX(10_000, 1_000_000);

    private int pageSize;
    private int sheetMaxRow;

    ExcelPageEnum(int pageSize, int sheetMaxRow) {
        this.pageSize = pageSize;
        this.sheetMaxRow = sheetMaxRow;
    }

}
