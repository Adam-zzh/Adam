package com.huamiao.blog.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.huamiao.blog.mapper.TArticleLabelMapper;
import com.huamiao.blog.mapper.TArticleMapper;
import com.huamiao.blog.model.TArticle;
import com.huamiao.blog.model.TArticleExample;
import com.huamiao.blog.model.TArticleLabel;
import com.huamiao.blog.model.TArticleLabelExample;
import com.huamiao.blog.util.IdHelper;
import com.huamiao.blog.vo.ArticleVo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import com.huamiao.common.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈文章业务〉
 *
 * @author ZZH
 * @create 2021/5/23
 * @since 1.0.0
 */
@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TArticleMapper tArticleMapper;
    @Autowired
    private TArticleLabelMapper tArticleLabelMapper;

    public PageVo<ArticleVo> selAllArticles(BaseParam baseParam) {
        if (StrUtil.isEmpty(baseParam.getOrderBy())){
            baseParam.setOrderBy("IF_TOP DESC, CRE_TIME DESC");
        }
        TArticleExample example = new ArticleExampleDefine();
        TArticleExample.Criteria criteriaDefine = example.createCriteria();

        ConditionHelper.createCondition(baseParam, criteriaDefine, ArticleDefine.class);
        PageVo<ArticleVo> pagination = PageHelper.pagination(baseParam, () -> articleMapper.selectByExampleWithBLOBs(example));
        if (pagination.getTotalPage() != 0 && pagination.getTotalPage() < pagination.getPageNum()){
            baseParam.setPage(pagination.getTotalPage());
            pagination = PageHelper.pagination(baseParam, () -> articleMapper.selectByExampleWithBLOBs(example));
        }
        pagination.getList().stream().map(item -> {renderYMD(item); return item;}).collect(Collectors.toList());
        return pagination;
    }

    public ResponseVo<ArticleVo> selArticleById(Long articleId) {
        TArticleExample example = new ArticleExampleDefine();
        TArticleExample.Criteria criteriaDefine = example.createCriteria();

        criteriaDefine.andIdEqualTo(articleId);
        return ResponseVo.success(articleMapper.selectByExampleWithBLOBs(example).get(0));
    }

    public ResponseVo saveOrUpdArticle(ArticleVo articleVo) {
        TArticle tArticle = null;
        List<TArticleLabel> articleLabels = articleVo.getArticleLabels();

        if (articleVo.getId() == null) {
            tArticle = new TArticle();
            articleVo.setId(IdHelper.generateLongId());
            BeanUtil.copyProperties(articleVo, tArticle);
            tArticle.setCreTime(DateUtil.date());
            tArticle.setCreId(SessionHelper.currentUserId());
            tArticle.setUpdTime(DateUtil.date());
            tArticle.setUpdId(SessionHelper.currentUserId());

            tArticleMapper.insertSelective(tArticle);
        }else {
            tArticle = tArticleMapper.selectByPrimaryKey(articleVo.getId());
            BeanUtil.copyProperties(articleVo, tArticle);
            tArticle.setUpdTime(DateUtil.date());
            tArticle.setUpdId(SessionHelper.currentUserId());

            tArticleMapper.updateByPrimaryKeySelective(tArticle);
        }

        //清空关联表 t_article_label
        if (articleVo.getId() != null) {
            TArticleLabelExample example = new TArticleLabelExample();
            example.createCriteria().andArticleIdEqualTo(articleVo.getId());

            tArticleLabelMapper.deleteByExample(example);
        }

        if (CollUtil.isNotEmpty(articleLabels)){
            articleLabels.stream().forEach(item -> {
                if (item.getId() == null) {
                    item.setId(IdHelper.generateLongId());
                }
                item.setArticleId(articleVo.getId());
                tArticleLabelMapper.insertSelective(item);
            });
        }

        return ResponseVo.success(null);
    }

    public ResponseVo delArticle(Long articleId) {
        tArticleMapper.deleteByPrimaryKey(articleId);

        //删除关联表
        TArticleLabelExample example = new TArticleLabelExample();
        example.createCriteria().andArticleIdEqualTo(articleId);

        tArticleLabelMapper.deleteByExample(example);
        return ResponseVo.success(null);
    }

    private void renderYMD(ArticleVo articleVo){
        Calendar cal = Calendar.getInstance();
        cal.setTime(articleVo.getCreTime());
        articleVo.setYear(cal.get(Calendar.YEAR));
        articleVo.setMonth(cal.get(Calendar.MONTH)+ 1);
        articleVo.setDate(cal.get(Calendar.DATE));
    }
}