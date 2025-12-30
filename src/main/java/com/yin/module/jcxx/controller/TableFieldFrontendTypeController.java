package com.yin.module.jcxx.controller;

import com.yin.module.jcxx.entity.TableFieldFrontendTypePojo;
import com.yin.module.jcxx.service.ITableFieldFrontendTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 前端显示类型配置表 前端控制器
 */
@RestController
@RequestMapping("/tableFieldFrontendType")
public class TableFieldFrontendTypeController {

    @Autowired
    private ITableFieldFrontendTypeService tableFieldFrontendTypeService;
    /*
        新增
    */
    @PostMapping("addTableFieldFrontendType")
    public Result<?> addTableFieldFrontendTypePojo(@RequestBody TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
    return tableFieldFrontendTypeService.addTableFieldFrontendType(tableFieldFrontendTypePojo);
    }
    //新增
    @PostMapping("addTableFieldFrontendTypeS")
    @Transactional
    public Result<?> addTableFieldFrontendTypePojo(@RequestBody List<TableFieldFrontendTypePojo> tableFieldFrontendTypePojos) {
        Result<?> result = null;
        for (TableFieldFrontendTypePojo tableFieldFrontendTypePojo : tableFieldFrontendTypePojos) {
        result = tableFieldFrontendTypeService.addTableFieldFrontendType(tableFieldFrontendTypePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteTableFieldFrontendType")
    public Result<?> deleteTableFieldFrontendTypePojo(@RequestBody TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return tableFieldFrontendTypeService.deleteTableFieldFrontendType(tableFieldFrontendTypePojo);
    }

    //修改
    @PostMapping("updateTableFieldFrontendType")
    public Result<?> updateTableFieldFrontendTypePojo(@RequestBody TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return tableFieldFrontendTypeService.updateTableFieldFrontendType(tableFieldFrontendTypePojo);
    }

    //查询
    @PostMapping("getTableFieldFrontendTypeList")
    public Result<?> getTableFieldFrontendTypePojoList(@RequestBody TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return tableFieldFrontendTypeService.getTableFieldFrontendTypeList(tableFieldFrontendTypePojo);
    }


    //分页查询
    @PostMapping("getTableFieldFrontendTypeListPage")
    public Result<?> getTableFieldFrontendTypePojoListPage(@RequestBody TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return tableFieldFrontendTypeService.getTableFieldFrontendTypeListPage(tableFieldFrontendTypePojo);
    }

}