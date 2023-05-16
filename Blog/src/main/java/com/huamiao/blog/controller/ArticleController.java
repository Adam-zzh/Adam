package com.huamiao.blog.controller;

import com.huamiao.blog.service.ArticleService;
import com.huamiao.blog.vo.ArticleVo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈文章管理〉
 *
 * @author ZZH
 * @create 2021/5/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/articleController")
@Api("文章管理")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("查询所有文章")
    @PostMapping(value = "articles")
    public PageVo<ArticleVo> selAllArticles(@RequestBody BaseParam baseParam){
        return articleService.selAllArticles(baseParam);
    }
    @ApiOperation("查询所有文章")
    @PostMapping(value = "public/articles")
    public PageVo<ArticleVo> publicArticles(@RequestBody BaseParam baseParam){
        return articleService.selAllArticles(baseParam);
    }

    @ApiOperation("查询文章")
    @GetMapping(value = "article/{articleId}")
    public ResponseVo<ArticleVo> selArticleById(@PathVariable("articleId") Long articleId){
        return articleService.selArticleById(articleId);
    }

    @ApiOperation("查询文章")
    @GetMapping(value = "public/article/{articleId}")
    public ResponseVo<ArticleVo> publicArticle(@PathVariable("articleId") Long articleId){
        return articleService.selArticleById(articleId);
    }

    @ApiOperation("保存更新文章")
    @PostMapping(value = "saveOrUpdArticle")
    public ResponseVo saveOrUpdArticle(@RequestBody ArticleVo articleVo){
        return articleService.saveOrUpdArticle(articleVo);
    }

    @ApiOperation("删除文章文章")
    @DeleteMapping(value = "article/{articleId}")
    public ResponseVo delArticle(@PathVariable("articleId") Long articleId){
        return articleService.delArticle(articleId);
    }

}