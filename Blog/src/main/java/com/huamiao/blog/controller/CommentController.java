package com.huamiao.blog.controller;

import com.huamiao.blog.model.TComment;
import com.huamiao.blog.service.CommentService;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2021/5/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("commentController")
@Api("评论管理")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    @ApiOperation("动态查询")
    public ResponseVo<Map> selAllComments(@RequestBody BaseParam baseParam){
        return commentService.selAllComments(baseParam);
    }

    @PostMapping("/public/comments")
    @ApiOperation("动态查询-公开")
    public ResponseVo<Map> publicAllComments(@RequestBody BaseParam baseParam){
        return commentService.selAllComments(baseParam);
    }

    @PostMapping("comment")
    @ApiOperation("发布评论")
    public ResponseVo saveComment(@RequestBody TComment comment){
        return commentService.saveComment(comment);
    }


    @DeleteMapping("comment/{id}")
    @ApiOperation("删除评论")
    public ResponseVo delComment(@PathVariable("id") Long id){
        return commentService.delComment(id);
    }

}