package com.yin.module.jcxx.controller;

import com.yin.common.Result;
import com.yin.module.jcxx.entity.DictionTableInfo;
import com.yin.module.jcxx.service.IDictionTableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionTableInfo")
public class DictionTableInfoController {
    @Autowired
    private IDictionTableInfoService dictionTableInfoService;


    @PostMapping("/getDictionTableInfoList")
    public Result<?> getDictionTableInfoList(@RequestBody DictionTableInfo dictionTableInfo) {
        if (null == dictionTableInfo.getTableName()) {
            return Result.error("请输入表名", "");
        }
        return dictionTableInfoService.getDictionTableInfoList(dictionTableInfo);
    }
}
