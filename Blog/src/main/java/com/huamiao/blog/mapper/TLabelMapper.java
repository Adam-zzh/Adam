package com.huamiao.blog.mapper;

import com.huamiao.blog.model.TLabel;
import com.huamiao.blog.model.TLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLabelMapper {
    long countByExample(TLabelExample example);

    int deleteByExample(TLabelExample example);

    int insert(TLabel record);

    int insertSelective(TLabel record);

    List<TLabel> selectByExample(TLabelExample example);

    int updateByExampleSelective(@Param("record") TLabel record, @Param("example") TLabelExample example);

    int updateByExample(@Param("record") TLabel record, @Param("example") TLabelExample example);
}