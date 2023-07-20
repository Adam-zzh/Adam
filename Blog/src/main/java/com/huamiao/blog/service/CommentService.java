package com.huamiao.blog.service;

import cn.hutool.core.date.DateUtil;
import com.huamiao.blog.mapper.TCommentMapper;
import com.huamiao.blog.model.TComment;
import com.huamiao.blog.model.TCommentExample;
import com.huamiao.blog.util.IdHelper;
import com.huamiao.common.base.UserSession;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论业务〉
 *
 * @author ZZH
 * @create 2021/5/25
 * @since 1.0.0
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    private TCommentMapper tCommentMapper;
    @Autowired
    private MessageService messageService;



    public ResponseVo<Map> selAllComments(BaseParam baseParam) {
        TCommentExample example = new TCommentExample();
        TCommentExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(HuamiaoConst.ZERO);
        long l = tCommentMapper.countByExample(example);
        criteria.andPidEqualTo(0l);

        ConditionHelper.createCondition(baseParam, criteria, TComment.class);

        Map data = new HashMap();
        data.put("list", tCommentMapper.selectByExample(example));
        data.put("total", l);

        return ResponseVo.success(data);
    }

    public ResponseVo saveComment(TComment comment) {
        long id = IdHelper.generateLongId();

        if (comment.getPid() == 0l) {
            comment.setFullPath("/" + id);
        } else {
            StringBuffer sb = new StringBuffer();
            TCommentExample commentExample = new TCommentExample();
            commentExample.createCriteria()
                    .andIdEqualTo(comment.getPid())
                    .andIsDelEqualTo(HuamiaoConst.ZERO);
            List<TComment> tComments = tCommentMapper.selectByExample(commentExample);
            sb.append(tComments.get(0).getFullPath()).append("/").append(id);

            comment.setFullPath(sb.toString());
        }
        comment.setId(id);
        comment.setCreId(UserSession.getUser().getUserId());
        comment.setCreTime(DateUtil.date());
        comment.setUpdId(UserSession.getUser().getUserId());
        comment.setUpdTime(DateUtil.date());
        comment.setSourceId(UserSession.getUser().getUserId());

        int i = tCommentMapper.insertSelective(comment);

        if (i < 1) {
            return ResponseVo.failed("发布失败");
        }

        //websocket 推送并保存消息
        messageService.pushCommentMessage(comment);

        return ResponseVo.success(i);
    }


    public ResponseVo delComment(Long id) {

        TComment tComment = tCommentMapper.selectByPrimaryKey(id);

        tComment.setIsDel(HuamiaoConst.ONE);
        tComment.setUpdId(UserSession.getUser().getUserId());
        tComment.setUpdTime(DateUtil.date());
        int i = tCommentMapper.updateByPrimaryKeySelective(tComment);

        if (i < 1) {
            return ResponseVo.failed("删除失败");
        }

        return ResponseVo.success(i, "删除成功");
    }

}