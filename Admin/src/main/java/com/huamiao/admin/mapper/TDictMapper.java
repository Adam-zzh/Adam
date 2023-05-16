package com.huamiao.admin.mapper;

import com.huamiao.admin.dto.DictCategory;
import com.huamiao.admin.model.TDict;
import com.huamiao.admin.model.TDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictMapper {
    long countByExample(TDictExample example);

    int deleteByExample(TDictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDict record);

    int insertSelective(TDict record);

    List<TDict> selectByExample(TDictExample example);

    TDict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByExample(@Param("record") TDict record, @Param("example") TDictExample example);

    int updateByPrimaryKeySelective(TDict record);

    int updateByPrimaryKey(TDict record);

    DictCategory queryDictCategoryList();
}