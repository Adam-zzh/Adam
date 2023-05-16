package com.huamiao.admin.controller;

import com.huamiao.admin.model.TDict;
import com.huamiao.admin.service.DictService;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据字典管理〉
 *
 * @author ZZH
 * @create 2021/5/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("dictController")
@Api("数据字典管理")
public class DictController {

    @Autowired
    private DictService dictService;

    @ApiOperation("更新或保存数据字典")
    @PostMapping("updOrSaveDict")
    public ResponseVo updOrSaveDict(@RequestBody TDict dict){
        return dictService.updOrSaveDict(dict);
    }

    @ApiOperation("根据分类code查出所有字典")
    @GetMapping("dict/{categoryCode}")
    public ResponseVo detailDict(@PathVariable("categoryCode") String categoryCode){
        return dictService.detailDict(categoryCode);
    }

    @ApiOperation("根据分类code和dictcode查出指定字典")
    @GetMapping("dict/{categoryCode}/{dictCode}")
    public ResponseVo detailOnlyDict(@PathVariable("categoryCode") String categoryCode,
                                   @PathVariable("dictCode") String dictCode){
        return dictService.detailOnlyDict(categoryCode, dictCode);
    }

    @ApiOperation("查出所有分类（按创建时间排序）")
    @GetMapping("categorys")
    public ResponseVo detailCategorys(){
        return dictService.detailCategoryList();
    }
}