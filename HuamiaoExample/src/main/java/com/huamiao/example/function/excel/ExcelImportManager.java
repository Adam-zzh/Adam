package com.huamiao.example.function.excel;

// service类实现该接口
public interface ExcelImportManager<T> {

    // 导入数据
    int importData(java.util.List<T> datas);

    /**
     * 对导入的数据自定义校验 校验成功返回null 否则返回对应错误信息
     * @param datas 要校验的数据
     * @param startNum 起始条数
     * @return
     */
    default String validateData(java.util.List<T> datas, int startNum)  {
        return null;
    };
}
