package com.huamiao.blog.controller;

import com.huamiao.blog.model.TLeavemsg;
import com.huamiao.blog.service.LeaveMessageService;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈留言管理〉
 *
 * @author ZZH
 * @create 2021/6/12
 * @since 1.0.0
 */
@Api(tags = "留言管理")
@RestController
@RequestMapping("leaveMessage")
public class LeaveMessageController {

    @Autowired
    private LeaveMessageService leaveMessageService;

    @ApiOperation("保存编辑留言")
    @PostMapping(value = "leaveMessage")
    public ResponseVo saveOrUpdateLeaveMsg(@RequestBody TLeavemsg leaveMsg){
        return leaveMessageService.saveOrUpdateLeaveMsg(leaveMsg);
    }

    @ApiOperation("根据id删除留言")
    @DeleteMapping(value = "leaveMessage/{id}")
    public ResponseVo delLeaveMsg(@PathVariable("id") Long id){
        return leaveMessageService.delLeaveMsg(id);
    }

    @ApiOperation("留言列表查看")
    @PostMapping(value = "/public/leaveMessageList")
    public PageVo leaveMessageList(@RequestBody BaseParam baseParam){
        return leaveMessageService.leaveMessageList(baseParam);
    }

}