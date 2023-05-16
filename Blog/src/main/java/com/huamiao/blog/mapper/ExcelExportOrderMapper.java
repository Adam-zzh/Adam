package com.huamiao.blog.mapper;

import com.huamiao.blog.model.ExcelExportOrder;
import com.huamiao.blog.model.ExcelExportOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExcelExportOrderMapper {
    long countByExample(ExcelExportOrderExample example);

    int deleteByExample(ExcelExportOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExcelExportOrder record);

    int insertSelective(ExcelExportOrder record);

    List<ExcelExportOrder> selectByExample(ExcelExportOrderExample example);

    ExcelExportOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExcelExportOrder record, @Param("example") ExcelExportOrderExample example);

    int updateByExample(@Param("record") ExcelExportOrder record, @Param("example") ExcelExportOrderExample example);

    int updateByPrimaryKeySelective(ExcelExportOrder record);

    int updateByPrimaryKey(ExcelExportOrder record);
}