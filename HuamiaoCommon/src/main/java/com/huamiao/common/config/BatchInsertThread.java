package com.huamiao.common.config;

import com.huamiao.common.util.ApplicationUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br>
 * 〈我的线程〉
 *
 * @author ZZH
 * @create 2021/5/24
 * @since 1.0.0
 */
@NoArgsConstructor
@Data
public class BatchInsertThread<D, M> implements Callable {

    private Integer batchNum;//第几个批次

    private List<D> segmentDatas;

    private Class mapperClazz;

    private Class entityClazz;

    public BatchInsertThread(Integer batchNum, List<D> datas, Class mapperClazz, Class entityClazz) {
        this.batchNum = batchNum;
        this.segmentDatas = datas;
        this.mapperClazz = mapperClazz;
        this.entityClazz = entityClazz;
    }

    public Object call() throws Exception {
        M mapper = (M) ApplicationUtil.getBean(this.mapperClazz);
        Method insert = mapperClazz.getDeclaredMethod("insert", entityClazz);
        segmentDatas.forEach(item -> {
            try {
                insert.invoke(mapper, item);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return true;
    }
}