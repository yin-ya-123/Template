package com.yin.module.jcxx.service;

import com.yin.common.Result;
import com.yin.module.jcxx.entity.DictionTableInfo;

public interface IDictionTableInfoService {

    Result<?> getDictionTableInfoList(DictionTableInfo dictionTableInfo);

    Result<?> getDictionTableInfoListPage(DictionTableInfo dictionTableInfo);

}
