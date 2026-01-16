package com.yin.module.fastReport.controller;

import com.yin.module.fastReport.entity.FastreportMainPojo;
import com.yin.module.fastReport.service.IFastreportMainService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * FastReport报表主表 前端控制器
 */
@RestController
@RequestMapping("/fastreportMain")
public class FastreportMainController {

    @Autowired
    private IFastreportMainService fastreportMainService;
    /*
        新增
    */
    @PostMapping("addFastreportMain")
    public Result<?> addFastreportMainPojo(@RequestBody FastreportMainPojo fastreportMainPojo) {
    return fastreportMainService.addFastreportMain(fastreportMainPojo);
    }
    //新增
    @PostMapping("addFastreportMainS")
    @Transactional
    public Result<?> addFastreportMainPojo(@RequestBody List<FastreportMainPojo> fastreportMainPojos) {
        Result<?> result = null;
        for (FastreportMainPojo fastreportMainPojo : fastreportMainPojos) {
        result = fastreportMainService.addFastreportMain(fastreportMainPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteFastreportMain")
    public Result<?> deleteFastreportMainPojo(@RequestBody FastreportMainPojo fastreportMainPojo) {
        return fastreportMainService.deleteFastreportMain(fastreportMainPojo);
    }

    //修改
    @PostMapping("updateFastreportMain")
    public Result<?> updateFastreportMainPojo(@RequestBody FastreportMainPojo fastreportMainPojo) {
        return fastreportMainService.updateFastreportMain(fastreportMainPojo);
    }

    //查询
    @PostMapping("getFastreportMainList")
    public Result<?> getFastreportMainPojoList(@RequestBody FastreportMainPojo fastreportMainPojo) {
        return fastreportMainService.getFastreportMainList(fastreportMainPojo);
    }


    //分页查询
    @PostMapping("getFastreportMainListPage")
    public Result<?> getFastreportMainPojoListPage(@RequestBody FastreportMainPojo fastreportMainPojo) {
        return fastreportMainService.getFastreportMainListPage(fastreportMainPojo);
    }

}