package com.yin.module.jsyy.controller;

import com.yin.module.jsyy.entity.DischargeInfoPojo;
import com.yin.module.jsyy.service.IDischargeInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 出院信息表 前端控制器
 */
@RestController
@RequestMapping("/dischargeInfo")
public class DischargeInfoController {

    @Autowired
    private IDischargeInfoService dischargeInfoService;
    /*
        新增
    */
    @PostMapping("addDischargeInfo")
    public Result<?> addDischargeInfoPojo(@RequestBody DischargeInfoPojo dischargeInfoPojo) {
    return dischargeInfoService.addDischargeInfo(dischargeInfoPojo);
    }
    //新增
    @PostMapping("addDischargeInfoS")
    @Transactional
    public Result<?> addDischargeInfoPojo(@RequestBody List<DischargeInfoPojo> dischargeInfoPojos) {
        Result<?> result = null;
        for (DischargeInfoPojo dischargeInfoPojo : dischargeInfoPojos) {
        result = dischargeInfoService.addDischargeInfo(dischargeInfoPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteDischargeInfo")
    public Result<?> deleteDischargeInfoPojo(@RequestBody DischargeInfoPojo dischargeInfoPojo) {
        return dischargeInfoService.deleteDischargeInfo(dischargeInfoPojo);
    }

    //修改
    @PostMapping("updateDischargeInfo")
    public Result<?> updateDischargeInfoPojo(@RequestBody DischargeInfoPojo dischargeInfoPojo) {
        return dischargeInfoService.updateDischargeInfo(dischargeInfoPojo);
    }

    //查询
    @PostMapping("getDischargeInfoList")
    public Result<?> getDischargeInfoPojoList(@RequestBody DischargeInfoPojo dischargeInfoPojo) {
        return dischargeInfoService.getDischargeInfoList(dischargeInfoPojo);
    }


    //分页查询
    @PostMapping("getDischargeInfoListPage")
    public Result<?> getDischargeInfoPojoListPage(@RequestBody DischargeInfoPojo dischargeInfoPojo) {
        return dischargeInfoService.getDischargeInfoListPage(dischargeInfoPojo);
    }

}