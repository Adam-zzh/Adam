package com.huamiao.example.listener.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.huamiao.common.exception.ImportExcelException;
import com.huamiao.example.function.excel.ExcelImportManager;
import com.huamiao.example.util.excel.ExcelUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * 〈通用excel导入监听〉
 *
 * @author ZZH
 * @create 2022/6/13
 * @since 1.0.0
 */
@Getter
@Slf4j
public class CommonReaderListener<T> extends AnalysisEventListener {

    private ExcelImportManager manager;

    // 默认处理多少条
    private int pageSize;

    public CommonReaderListener(ExcelImportManager manager) {
        this(manager, 5000);
    }

    public CommonReaderListener(ExcelImportManager manager, int pageSize) {
        this.manager = manager;
        this.pageSize = pageSize;
    }

    // 银行流水集合
    private java.util.List<T> bankFlowList = new ArrayList<>();

    // 第几页 用于validateDate指定具体行数的前缀
    private int count;

    @Override
    public void invoke(Object o, AnalysisContext context) {
        String errMsg;
        T t = (T) o;
        try {
            errMsg = ExcelUtils.validateEntity(t);
        } catch (NoSuchFieldException e) {
            errMsg = "解析数据出错";
            e.printStackTrace();
        }

        if (!StringUtils.isEmpty(errMsg)) dealException(context.getCurrentRowNum(), errMsg);


        bankFlowList.add(t);

        if (bankFlowList.size() >= pageSize) {
            dealData();
        }

    }

    private void dealException(Integer rowNum, String msg) {
        rowNum = rowNum == null ? 0 : rowNum;
        String prefix = "第".concat(String.valueOf(rowNum)).concat("行");
        throw new ImportExcelException(prefix.concat(msg));
    }

    private void dealData() {
        String msg = manager.validateData(bankFlowList, count*pageSize);
        if (!StringUtils.isEmpty(msg)) throw new ImportExcelException(msg);
        manager.importData(bankFlowList);

        bankFlowList.clear();
        count++;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if(!CollectionUtils.isEmpty(bankFlowList)) dealData();
        log.info("全部解析完成");
    }
}