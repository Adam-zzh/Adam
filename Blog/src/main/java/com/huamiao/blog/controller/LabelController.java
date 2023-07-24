package com.huamiao.blog.controller;

import com.google.common.collect.Lists;
import com.huamiao.blog.service.LabelService;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈标签管理〉
 *
 * @author ZZH
 * @create 2021/5/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("labelController")
@Api("标签管理")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @ApiOperation("发布文章-》添加标签级联查询")
    @GetMapping("labels")
    public ResponseVo<List<Object>> getAllLabels(){
        return ResponseVo.success(Lists.newArrayList());
    }

    @ApiOperation("文章列表-》右侧面板")
    @GetMapping("rightPanel")
    public ResponseVo<Object> rightPanel(){
        return ResponseVo.success(null);
    }

    @ApiOperation("文章列表-》右侧面板")
    @GetMapping("public/rightPanel")
    public ResponseVo<Object> publicRightPanel(){
        return ResponseVo.success(null);
    }
}