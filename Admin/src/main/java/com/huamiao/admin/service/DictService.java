package com.huamiao.admin.service;

import com.huamiao.admin.mapper.TDictMapper;
import com.huamiao.admin.model.TDict;
import com.huamiao.admin.model.TDictExample;
import com.huamiao.admin.model.TUser;
import com.huamiao.admin.util.IdHelper;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.RedisHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据字典功能〉
 *
 * @author ZZH
 * @create 2021/5/22
 * @since 1.0.0
 */
@Service
public class DictService {

    @Autowired
    private TDictMapper dictMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Transactional
    public ResponseVo updOrSaveDict(TDict dict) {
//        UserRole us = SessionUtil.getAttribute(ConstUtil.REDIS_USER, UserRole.class);
        TUser us = RedisHelper.getUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()));
        int i = 0;
        if (dict.getId() == null) {
            dict.setId(IdHelper.generateLongId());
            dict.setCreateTime(new Date());
            dict.setUpdateTime(new Date());
            dict.setCreateId(us.getId());
            dict.setUpdateId(us.getId());

            i = dictMapper.insertSelective(dict);
        } else {
            TDictExample example = new TDictExample();
            example.createCriteria().andIdEqualTo(dict.getId());
            TDict tDict = dictMapper.selectByExample(example).get(0);

            if (!Objects.equals(tDict.getVersion(), dict.getVersion())) {
                return new ResponseVo().failed("信息已改变，请刷新页面在更新");
            }
            BeanUtils.copyProperties(dict, tDict);
            tDict.setCreateTime(new Date());
            tDict.setUpdateTime(new Date());
            tDict.setCreateId(us.getId());
            tDict.setUpdateId(us.getId());

            i = dictMapper.updateByPrimaryKeySelective(tDict);

        }
        return new ResponseVo().success(i);
    }

    public ResponseVo detailDict(String categoryCode) {
        TDictExample example = new TDictExample();
        example.setOrderByClause("SEQUENCE");
        example.createCriteria()
                .andCategoryCodeEqualTo(categoryCode.trim());
        List<TDict> tDicts = dictMapper.selectByExample(example);
        return new ResponseVo().success(tDicts);
    }

    public ResponseVo detailOnlyDict(String categoryCode, String dictCode) {
        TDictExample example = new TDictExample();
        example.createCriteria()
                .andCategoryCodeEqualTo(categoryCode.trim())
                .andDictCodeEqualTo(dictCode);
        List<TDict> tDicts = dictMapper.selectByExample(example);
        return new ResponseVo().success(tDicts.get(0));
    }

    public ResponseVo detailCategoryList() {
        return new ResponseVo().success(dictMapper.queryDictCategoryList());
    }
}