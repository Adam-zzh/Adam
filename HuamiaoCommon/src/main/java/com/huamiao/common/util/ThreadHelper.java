package com.huamiao.common.util;

import com.huamiao.common.config.BatchInsertThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池工具类〉
 * R Futurn返回类型 D实体类型 M Mapper类型
 * @author ZZH
 * @create 2021/5/24
 * @since 1.0.0
 */
@Component
public class ThreadHelper<D, M> {
    @Autowired
    @Qualifier("defaultTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public Boolean batchInsert(List<D> datas, Class mapperClazz, Class entityClazz){
        List<Future<Boolean>> futureList = new ArrayList<Future<Boolean>>();
        //集合总条数
        int size = datas.size();
        //将集合切分的段数(2*CPU的核心数)
        int sunSum = 2*Runtime.getRuntime().availableProcessors();
        int listStart,listEnd;
        //当总条数不足sunSum条时 用总条数 当做线程切分值
        if(sunSum > size){
            sunSum = size;
        }

        BatchInsertThread<D, M> myThread = null;

        //将list 切分多份 多线程执行
        for (int i = 0; i < sunSum; i++) {
            //计算切割  开始和结束
            listStart = size / sunSum * i ;
            listEnd = size / sunSum * ( i + 1 );
            //最后一段线程会 出现与其他线程不等的情况
            if(i == sunSum - 1){
                listEnd = size;
            }
            //线程切断**/
            List<D> sunList = datas.subList(listStart,listEnd);
            //子线程初始化
            myThread = new BatchInsertThread(i,sunList, mapperClazz, entityClazz);

            //多线程执行
            futureList.add(threadPoolTaskExecutor.submit(myThread));
        }


        for(Future<Boolean> future : futureList){
            try {
                if(null != future ){
                    future.get();
                }else{
                    return false;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();

            }
        }

        return true;
    }

}