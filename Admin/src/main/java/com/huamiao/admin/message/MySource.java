package com.huamiao.admin.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者通道 输出数据到消息队列〉
 *
 * @author ZZH
 * @create 2021/6/3
 * @since 1.0.0
 */
public interface MySource {

    String OUTPUT_ADMIN_USER = "output_admin_user";

    @Output(OUTPUT_ADMIN_USER)
    MessageChannel outputUser();

}