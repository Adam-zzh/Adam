package com.huamiao.gateway.service.impl;

import com.huamiao.gateway.service.DynamicSecurityService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/5/18
 * @since 1.0.0
 */
@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    @Override
    public Map<String, ConfigAttribute> loadDataSource() {
        return null;
    }
}