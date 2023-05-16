package com.huamiao.blog.message;

import cn.hutool.json.JSONUtil;
import com.smallhua.org.mapper.TUserMirMapper;
import com.smallhua.org.model.TUserMir;
import com.smallhua.org.stream.channel.MySink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈消费消息〉
 *
 * @author ZZH
 * @create 2021/6/3
 * @since 1.0.0
 */
@Component
@Slf4j
@EnableBinding(MySink.class)
public class ConsumeMessage {

    @Autowired
    private TUserMirMapper userMirMapper;

    @StreamListener(MySink.INPUT_BLOG_USER)
    public void receiveUser(Object obj) {
        TUserMir tUserMir = JSONUtil.toBean(obj.toString(), TUserMir.class);
        log.info("接受一条{}用户信息", tUserMir);
        userMirMapper.insertSelective(tUserMir);
    }

}