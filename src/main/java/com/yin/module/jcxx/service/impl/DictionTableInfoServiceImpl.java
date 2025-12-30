package com.yin.module.jcxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import com.yin.module.jcxx.entity.DictionTableInfo;
import com.yin.module.jcxx.mapper.DictionTableInfoMapper;
import com.yin.module.jcxx.service.IDictionTableInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionTableInfoServiceImpl extends BaseServiceImpl<DictionTableInfoMapper, DictionTableInfo> implements IDictionTableInfoService {
    public LambdaQueryWrapper<DictionTableInfo> dictionTableInfoLambdaQueryWrapper(DictionTableInfo dictionTableInfo) {
        LambdaQueryWrapper<DictionTableInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (dictionTableInfo.getTableName() != null && !dictionTableInfo.getTableName().isEmpty()) {
            queryWrapper.eq(DictionTableInfo::getTableName, dictionTableInfo.getTableName());
        }
        return queryWrapper;
    }

    @Override
    public Result<?> getDictionTableInfoList(DictionTableInfo dictionTableInfo) {
        Result<List<DictionTableInfo>> listResult = selectFORList(dictionTableInfoLambdaQueryWrapper(dictionTableInfo));
        List<DictionTableInfo> data = listResult.getData();
        for (DictionTableInfo datum : data) {
            datum.setJavaColumnName(underlineToCamel(datum.getColumnName()));
        }
        return listResult;
    }

    @Override
    public Result<?> getDictionTableInfoListPage(DictionTableInfo dictionTableInfo) {
        return selectPage(dictionTableInfo, dictionTableInfoLambdaQueryWrapper(dictionTableInfo));
    }

    /**
     * 下划线命名转驼峰命名
     */
    private static String underlineToCamel(String str) {
        str = str.toLowerCase();
        StringBuilder result = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                nextUpperCase = true;
            } else {
                if (nextUpperCase) {
                    result.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
