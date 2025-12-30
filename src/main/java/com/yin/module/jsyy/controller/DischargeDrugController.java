package com.yin.module.jsyy.controller;

import com.yin.module.jsyy.entity.DischargeDrugPojo;
import com.yin.module.jsyy.service.IDischargeDrugService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 出院信息附属药物表 前端控制器
 */
@RestController
@RequestMapping("/dischargeDrug")
public class DischargeDrugController {

    @Autowired
    private IDischargeDrugService dischargeDrugService;
    /*
        新增
    */
    @PostMapping("addDischargeDrug")
    public Result<?> addDischargeDrugPojo(@RequestBody DischargeDrugPojo dischargeDrugPojo) {
    return dischargeDrugService.addDischargeDrug(dischargeDrugPojo);
    }
    //新增
    @PostMapping("addDischargeDrugS")
    @Transactional
    public Result<?> addDischargeDrugPojo(@RequestBody List<DischargeDrugPojo> dischargeDrugPojos) {
        Result<?> result = null;
        for (DischargeDrugPojo dischargeDrugPojo : dischargeDrugPojos) {
        result = dischargeDrugService.addDischargeDrug(dischargeDrugPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteDischargeDrug")
    public Result<?> deleteDischargeDrugPojo(@RequestBody DischargeDrugPojo dischargeDrugPojo) {
        return dischargeDrugService.deleteDischargeDrug(dischargeDrugPojo);
    }

    //修改
    @PostMapping("updateDischargeDrug")
    public Result<?> updateDischargeDrugPojo(@RequestBody DischargeDrugPojo dischargeDrugPojo) {
        return dischargeDrugService.updateDischargeDrug(dischargeDrugPojo);
    }

    //查询
    @PostMapping("getDischargeDrugList")
    public Result<?> getDischargeDrugPojoList(@RequestBody DischargeDrugPojo dischargeDrugPojo) {
        return dischargeDrugService.getDischargeDrugList(dischargeDrugPojo);
    }


    //分页查询
    @PostMapping("getDischargeDrugListPage")
    public Result<?> getDischargeDrugPojoListPage(@RequestBody DischargeDrugPojo dischargeDrugPojo) {
        return dischargeDrugService.getDischargeDrugListPage(dischargeDrugPojo);
    }

}