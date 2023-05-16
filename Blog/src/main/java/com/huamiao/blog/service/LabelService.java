package com.huamiao.blog.service;

import cn.hutool.core.collection.CollUtil;
import com.huamiao.blog.vo.CascadeVo;
import com.huamiao.blog.vo.RightPanelVo;
import com.huamiao.common.entity.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈标签功能〉
 *
 * @author ZZH
 * @create 2021/5/27
 * @since 1.0.0
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelMapper labelMapper;


    public ResponseVo getAllLabels() {
        List<CascadeVo> cascadeVos = labelMapper.queryType();

        if (CollUtil.isNotEmpty(cascadeVos)) {
            cascadeVos.stream().forEach(item -> {
                item.setChildren(labelMapper.queryLabel(Long.valueOf(item.getValue())));
            });
        }

        return new ResponseVo().success(cascadeVos);
    }

    public ResponseVo rightPanel() {
        RightPanelVo rightPanelVo = new RightPanelVo();
        List<String> types = labelMapper.queryType()
                .stream()
                .map(item -> {
                    return item.getLabel();
                })
                .collect(Collectors.toList());
        types.add("其他");
        List<String> labels = labelMapper.queryAllLabel()
                .stream()
                .map(item -> {
                    return item.getLabel();
                })
                .collect(Collectors.toList());
        rightPanelVo.setTypes(types);
        rightPanelVo.setLabels(labels);
        return new ResponseVo().success(rightPanelVo);
    }
}