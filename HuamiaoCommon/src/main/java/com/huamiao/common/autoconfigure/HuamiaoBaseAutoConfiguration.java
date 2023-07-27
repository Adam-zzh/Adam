package com.huamiao.common.autoconfigure;

import com.huamiao.common.config.MyProjectConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/7/27
 * @since 1.0.0
 */
@Configuration
@Lazy(false)
@Import(MyProjectConfig.class)
public class HuamiaoBaseAutoConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
    }


}