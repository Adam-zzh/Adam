package com.huamiao.example.strategy;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * 〈一句话功能简述〉<br>
 * 〈订单状态导出策略〉
 *
 * @author ZZH
 * @create 2022/4/13
 * @since 1.0.0
 */
public class OrderStatusStrategy implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadConverterContext<?> context) throws Exception {

        String cellStr = context.getReadCellData().getStringValue();

        if ("销售".equals(cellStr)){
            return 0;
        } else if ("退货".equals(cellStr)){
            return 1;
        } else {
            return null;
        }

    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) throws Exception {
        Integer value = context.getValue();
        if (value == 0){
            return new WriteCellData<>("销售");
        } else if (value == 1){
            return new WriteCellData<>("退货");
        } else {
            return new WriteCellData<>("");
        }
    }
}