package com.huamiao.admin.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产消息〉
 *
 * @author ZZH
 * @create 2021/6/3
 * @since 1.0.0
 */
@Component
@EnableBinding(MySource.class)
@Slf4j
public class ProductMessage {

    @Autowired
    private MySource mySource;

    public boolean produceUserMsg(Object data) {
        log.info("向front服务推了一条用户信息");
        return mySource.outputUser().send(message(data));
    }

    private Message message(Object data){
        return MessageBuilder.withPayload(data).build();
    }

}