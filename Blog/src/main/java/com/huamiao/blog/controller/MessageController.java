package com.huamiao.blog.controller;

import com.huamiao.blog.model.TMessage;
import com.huamiao.blog.service.MessageService;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈消息管理〉
 *
 * @author ZZH
 * @create 2021/6/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("messageController")
@Api("消息管理")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation("获得当前用户所有未读消息")
    @GetMapping(value = "messages")
    public List<TMessage> queryUnReadMessage() {
        return messageService.queryUnReadMessageByUserId();
    }

    @ApiOperation("根据类型获取所有消息")
    @PostMapping(value = "messagesByType/{type}")
    public PageVo<TMessage> queryMessagesByType(@PathVariable("type") Byte type, @RequestBody BaseParam baseParam) {
        return messageService.queryMessagesByType(type, baseParam);
    }

    @ApiOperation("根据id更新已读")
    @PutMapping(value = "message/{id}")
    public ResponseVo updateReadById(@PathVariable("id") Long id) {
        return messageService.updateReadById(id);
    }
}