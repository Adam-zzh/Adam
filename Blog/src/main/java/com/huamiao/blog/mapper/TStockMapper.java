package com.huamiao.blog.mapper;

import com.huamiao.blog.model.TStock;
import com.huamiao.blog.model.TStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStockMapper {
    long countByExample(TStockExample example);

    int deleteByExample(TStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TStock record);

    int insertSelective(TStock record);

    List<TStock> selectByExample(TStockExample example);

    TStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TStock record, @Param("example") TStockExample example);

    int updateByExample(@Param("record") TStock record, @Param("example") TStockExample example);

    int updateByPrimaryKeySelective(TStock record);

    int updateByPrimaryKey(TStock record);
}