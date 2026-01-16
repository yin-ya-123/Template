package com.yin.module.fastReport.controller;

import com.yin.module.fastReport.entity.FastreportSqlDatasourcePojo;
import com.yin.module.fastReport.service.IFastreportSqlDatasourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * FastReport报表SQL数据源表 前端控制器
 */
@RestController
@RequestMapping("/fastreportSqlDatasource")
public class FastreportSqlDatasourceController {

    @Autowired
    private IFastreportSqlDatasourceService fastreportSqlDatasourceService;
    /*
        新增
    */
    @PostMapping("addFastreportSqlDatasource")
    public Result<?> addFastreportSqlDatasourcePojo(@RequestBody FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
    return fastreportSqlDatasourceService.addFastreportSqlDatasource(fastreportSqlDatasourcePojo);
    }
    //新增
    @PostMapping("addFastreportSqlDatasourceS")
    @Transactional
    public Result<?> addFastreportSqlDatasourcePojo(@RequestBody List<FastreportSqlDatasourcePojo> fastreportSqlDatasourcePojos) {
        Result<?> result = null;
        for (FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo : fastreportSqlDatasourcePojos) {
        result = fastreportSqlDatasourceService.addFastreportSqlDatasource(fastreportSqlDatasourcePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteFastreportSqlDatasource")
    public Result<?> deleteFastreportSqlDatasourcePojo(@RequestBody FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return fastreportSqlDatasourceService.deleteFastreportSqlDatasource(fastreportSqlDatasourcePojo);
    }

    //修改
    @PostMapping("updateFastreportSqlDatasource")
    public Result<?> updateFastreportSqlDatasourcePojo(@RequestBody FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return fastreportSqlDatasourceService.updateFastreportSqlDatasource(fastreportSqlDatasourcePojo);
    }

    //查询
    @PostMapping("getFastreportSqlDatasourceList")
    public Result<?> getFastreportSqlDatasourcePojoList(@RequestBody FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return fastreportSqlDatasourceService.getFastreportSqlDatasourceList(fastreportSqlDatasourcePojo);
    }


    //分页查询
    @PostMapping("getFastreportSqlDatasourceListPage")
    public Result<?> getFastreportSqlDatasourcePojoListPage(@RequestBody FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return fastreportSqlDatasourceService.getFastreportSqlDatasourceListPage(fastreportSqlDatasourcePojo);
    }

}