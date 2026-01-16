package com.yin.module.fastReport.controller;

import com.yin.module.fastReport.entity.FastreportParamPojo;
import com.yin.module.fastReport.service.IFastreportParamService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * FastReport报表参数信息表 前端控制器
 */
@RestController
@RequestMapping("/fastreportParam")
public class FastreportParamController {

    @Autowired
    private IFastreportParamService fastreportParamService;
    /*
        新增
    */
    @PostMapping("addFastreportParam")
    public Result<?> addFastreportParamPojo(@RequestBody FastreportParamPojo fastreportParamPojo) {
    return fastreportParamService.addFastreportParam(fastreportParamPojo);
    }
    //新增
    @PostMapping("addFastreportParamS")
    @Transactional
    public Result<?> addFastreportParamPojo(@RequestBody List<FastreportParamPojo> fastreportParamPojos) {
        Result<?> result = null;
        for (FastreportParamPojo fastreportParamPojo : fastreportParamPojos) {
        result = fastreportParamService.addFastreportParam(fastreportParamPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteFastreportParam")
    public Result<?> deleteFastreportParamPojo(@RequestBody FastreportParamPojo fastreportParamPojo) {
        return fastreportParamService.deleteFastreportParam(fastreportParamPojo);
    }

    //修改
    @PostMapping("updateFastreportParam")
    public Result<?> updateFastreportParamPojo(@RequestBody FastreportParamPojo fastreportParamPojo) {
        return fastreportParamService.updateFastreportParam(fastreportParamPojo);
    }

    //查询
    @PostMapping("getFastreportParamList")
    public Result<?> getFastreportParamPojoList(@RequestBody FastreportParamPojo fastreportParamPojo) {
        return fastreportParamService.getFastreportParamList(fastreportParamPojo);
    }


    //分页查询
    @PostMapping("getFastreportParamListPage")
    public Result<?> getFastreportParamPojoListPage(@RequestBody FastreportParamPojo fastreportParamPojo) {
        return fastreportParamService.getFastreportParamListPage(fastreportParamPojo);
    }

}