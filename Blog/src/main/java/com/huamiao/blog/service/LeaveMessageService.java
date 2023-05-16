package com.huamiao.blog.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.PageUtil;
import com.huamiao.blog.mapper.TLeavemsgMapper;
import com.huamiao.blog.model.TLeavemsg;
import com.huamiao.blog.model.TLeavemsgExample;
import com.huamiao.blog.util.IdHelper;
import com.huamiao.blog.vo.LefMsgVo;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import com.huamiao.common.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈留言功能〉
 *
 * @author ZZH
 * @create 2021/6/12
 * @since 1.0.0
 */
@Service
@Transactional
public class LeaveMessageService {

    @Autowired
    private TLeavemsgMapper tLeavemsgMapper;
    @Autowired
    private MessageService messageService;
    @Autowired
    private LefMsgMapper lefMsgMapper;


    public ResponseVo saveOrUpdateLeaveMsg(TLeavemsg leaveMsg) {
        Long id = leaveMsg.getId()==null ? IdHelper.generateLongId() : leaveMsg.getId();
        leaveMsg.setSourceId(SessionHelper.currentUserId());
        leaveMsg.setUpdTime(DateUtil.date());
        leaveMsg.setUpdId(SessionHelper.currentUserId());

        if (leaveMsg.getPid() == 0l) {
            leaveMsg.setFullPath("/" + id);
        } else {
            StringBuffer sb = new StringBuffer();
            TLeavemsgExample example = new TLeavemsgExample();
            example.createCriteria()
                    .andIdEqualTo(leaveMsg.getPid())
                    .andIsDelEqualTo(HuamiaoConst.ZERO);
            List<TLeavemsg> tComments = tLeavemsgMapper.selectByExample(example);
            sb.append(tComments.get(0).getFullPath()).append("/").append(id);

            leaveMsg.setFullPath(sb.toString());
        }

        if (leaveMsg.getId() == null) {
            //新增
            leaveMsg.setId(id);
            leaveMsg.setCreId(SessionHelper.currentUserId());
            leaveMsg.setCreTime(DateUtil.date());
            tLeavemsgMapper.insertSelective(leaveMsg);
            messageService.pushLeaveMessage(leaveMsg);
        }else {
            tLeavemsgMapper.updateByPrimaryKeySelective(leaveMsg);
        }

        return ResponseVo.success(leaveMsg);
    }

    public ResponseVo delLeaveMsg(Long id) {
//        tLeavemsgMapper.deleteByPrimaryKey(id);
        TLeavemsg leaveMsg = new TLeavemsg();
        leaveMsg.setId(id);
        leaveMsg.setIsDel((byte) 1);
        leaveMsg.setUpdTime(DateUtil.date());
        leaveMsg.setUpdId(SessionHelper.currentUserId());

        tLeavemsgMapper.updateByPrimaryKeySelective(leaveMsg);
        return ResponseVo.success(null);
    }

    public PageVo leaveMessageList(BaseParam baseParam) {
        TLeavemsgExample leavemsgExample = new TLeavemsgExample();
        leavemsgExample.setOrderByClause("CRE_TIME DESC");
        TLeavemsgExample.Criteria criteria = leavemsgExample.createCriteria();
        criteria.andIsDelEqualTo(HuamiaoConst.ZERO)
        .andPidEqualTo(0l);

        ConditionHelper.createCondition(baseParam, criteria, LefMsgVo.class);

        return PageHelper.pagination(baseParam, () -> lefMsgMapper.selectByExample(leavemsgExample));
    }
}