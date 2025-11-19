package com.yin.module.jcxx.controller;

import com.yin.module.jcxx.entity.DictionaryInfoPojo;
import com.yin.module.jcxx.service.IDictionaryInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 通用的字典信息表 前端控制器
 */
@RestController
@RequestMapping("/dictionaryInfo")
public class DictionaryInfoController {

    @Autowired
    private IDictionaryInfoService dictionaryInfoService;
    /*
        新增
    */
    @PostMapping("addDictionaryInfo")
    public Result<?> addDictionaryInfoPojo(@RequestBody DictionaryInfoPojo dictionaryInfoPojo) {
    return dictionaryInfoService.addDictionaryInfo(dictionaryInfoPojo);
    }
    //新增
    @PostMapping("addDictionaryInfoS")
    @Transactional
    public Result<?> addDictionaryInfoPojo(@RequestBody List<DictionaryInfoPojo> dictionaryInfoPojos) {
        Result<?> result = null;
        for (DictionaryInfoPojo dictionaryInfoPojo : dictionaryInfoPojos) {
        result = dictionaryInfoService.addDictionaryInfo(dictionaryInfoPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteDictionaryInfo")
    public Result<?> deleteDictionaryInfoPojo(@RequestBody DictionaryInfoPojo dictionaryInfoPojo) {
        return dictionaryInfoService.deleteDictionaryInfo(dictionaryInfoPojo);
    }

    //修改
    @PostMapping("updateDictionaryInfo")
    public Result<?> updateDictionaryInfoPojo(@RequestBody DictionaryInfoPojo dictionaryInfoPojo) {
        return dictionaryInfoService.updateDictionaryInfo(dictionaryInfoPojo);
    }

    //查询
    @PostMapping("getDictionaryInfoList")
    public Result<?> getDictionaryInfoPojoList(@RequestBody DictionaryInfoPojo dictionaryInfoPojo) {
        return dictionaryInfoService.getDictionaryInfoList(dictionaryInfoPojo);
    }


    //分页查询
    @PostMapping("getDictionaryInfoListPage")
    public Result<?> getDictionaryInfoPojoListPage(@RequestBody DictionaryInfoPojo dictionaryInfoPojo) {
        return dictionaryInfoService.getDictionaryInfoListPage(dictionaryInfoPojo);
    }

}