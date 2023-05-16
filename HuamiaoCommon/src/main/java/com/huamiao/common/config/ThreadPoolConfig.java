package com.huamiao.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池配置〉
 *
 * @author ZZH
 * @create 2021/5/24
 * @since 1.0.0
 */
@Configuration
public class ThreadPoolConfig {
    //核心线程数
    @Value("${MyThreadPool.core.poolsize:5}")
    private int corePoolSize;
    //最大线程数
    @Value("${MyThreadPool.max.poolsize:10}")
    private int maxPoolSize;
    //队列容量
    @Value("${MyThreadPool.queue.capacity:100}")
    private int queueCapacity;
    //线程活跃时间（秒）
    @Value("${MyThreadPool.keepAlive.seconds:60}")
    private int keepAliveSeconds;
    //默认线程名称
    @Value("${MyThreadPool.thread.name.prefix:zzhPool}")
    private String threadNamePrefix;

    /**
     * bookTaskExecutor:(接口的线程池). <br/>
     * @return TaskExecutor taskExecutor接口
     * @since JDK 1.8
     */
    @Bean(name="defaultTaskExecutor")
    public ThreadPoolTaskExecutor defaultTaskExecutor() {
        //newFixedThreadPool
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix(threadNamePrefix);
        // 设置拒绝策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}