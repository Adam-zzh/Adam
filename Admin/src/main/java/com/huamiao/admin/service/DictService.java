package com.huamiao.admin.service;

import com.huamiao.admin.model.TDict;
import com.huamiao.common.entity.ResponseVo;

public interface DictService {

    ResponseVo updOrSaveDict(TDict dict);

    ResponseVo detail(String categoryCode);

    ResponseVo detailOnlyOne(String categoryCode, String dictCode);

    ResponseVo detailCategoryList();
}
