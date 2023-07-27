package com.huamiao.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.huamiao.common.base.UserSession;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试控制器〉
 *
 * @author ZZH
 * @create 2023/7/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("test")
@Api("测试接口")
public class TestController {

    @PostMapping("token")
    @ApiOperation("测试request")
    public ResponseVo<Object> testToken(HttpServletRequest request){
        Enumeration<String> attributeNames = request.getHeaderNames();
        System.out.println(request.getHeader("Authorization"));
        return ResponseVo.success(JSONObject.toJSONString(UserSession.getUser()));
    }

}