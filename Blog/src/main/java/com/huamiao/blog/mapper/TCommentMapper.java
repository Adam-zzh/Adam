package com.huamiao.blog.mapper;

import com.huamiao.blog.model.TComment;
import com.huamiao.blog.model.TCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCommentMapper {
    long countByExample(TCommentExample example);

    int deleteByExample(TCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TComment record);

    int insertSelective(TComment record);

    List<TComment> selectByExample(TCommentExample example);

    TComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TComment record, @Param("example") TCommentExample example);

    int updateByExample(@Param("record") TComment record, @Param("example") TCommentExample example);

    int updateByPrimaryKeySelective(TComment record);

    int updateByPrimaryKey(TComment record);
}