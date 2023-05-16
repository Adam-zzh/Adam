package com.huamiao.blog.mapper;

import com.huamiao.blog.model.TArticle;
import com.huamiao.blog.model.TArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticleMapper {
    long countByExample(TArticleExample example);

    int deleteByExample(TArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TArticle record);

    int insertSelective(TArticle record);

    List<TArticle> selectByExampleWithBLOBs(TArticleExample example);

    List<TArticle> selectByExample(TArticleExample example);

    TArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByExample(@Param("record") TArticle record, @Param("example") TArticleExample example);

    int updateByPrimaryKeySelective(TArticle record);

    int updateByPrimaryKeyWithBLOBs(TArticle record);

    int updateByPrimaryKey(TArticle record);
}