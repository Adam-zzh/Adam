package com.huamiao.blog.mapper;

import com.huamiao.blog.model.ExcelExportOrderProduct;
import com.huamiao.blog.model.ExcelExportOrderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExcelExportOrderProductMapper {
    long countByExample(ExcelExportOrderProductExample example);

    int deleteByExample(ExcelExportOrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExcelExportOrderProduct record);

    int insertSelective(ExcelExportOrderProduct record);

    List<ExcelExportOrderProduct> selectByExample(ExcelExportOrderProductExample example);

    ExcelExportOrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExcelExportOrderProduct record, @Param("example") ExcelExportOrderProductExample example);

    int updateByExample(@Param("record") ExcelExportOrderProduct record, @Param("example") ExcelExportOrderProductExample example);

    int updateByPrimaryKeySelective(ExcelExportOrderProduct record);

    int updateByPrimaryKey(ExcelExportOrderProduct record);
}