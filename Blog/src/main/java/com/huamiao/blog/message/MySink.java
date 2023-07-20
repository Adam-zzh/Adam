package com.huamiao.blog.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 〈一句话功能简述〉<br>
 * 〈消费者通道 订阅消息队列进行消费〉
 *
 * @author ZZH
 * @create 2021/6/3
 * @since 1.0.0
 */
public interface MySink {

    //通道名称：
    String INPUT_BLOG_USER = "input_blog_user";

    @Input(INPUT_BLOG_USER)
    SubscribableChannel inputUser();

}