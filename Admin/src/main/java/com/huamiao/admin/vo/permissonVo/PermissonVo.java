package com.huamiao.admin.vo.permissonVo;

import com.huamiao.admin.model.TPermission;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈为permisson增加一下表中不存的字段〉
 *
 * @author ZZH
 * @create 2021/5/21
 * @since 1.0.0
 */
@Data
public class PermissonVo extends TPermission {

    private Byte ifHasResource;//是否拥有资源 0否 1是

}