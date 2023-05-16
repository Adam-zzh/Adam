package com.huamiao.blog.mapper;

import com.huamiao.blog.model.TMessage;
import com.huamiao.blog.model.TMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageMapper {
    long countByExample(TMessageExample example);

    int deleteByExample(TMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TMessage record);

    int insertSelective(TMessage record);

    List<TMessage> selectByExample(TMessageExample example);

    TMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByExample(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByPrimaryKeySelective(TMessage record);

    int updateByPrimaryKey(TMessage record);
}