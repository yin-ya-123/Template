package com.yin.module.user.controller;

import com.yin.module.user.entity.PermissionTablePojo;
import com.yin.module.user.service.IPermissionTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 权限表 前端控制器
 */
@RestController
@RequestMapping("/permissionTable")
public class PermissionTableController {

    @Autowired
    private IPermissionTableService permissionTableService;
    /*
        新增
    */
    @PostMapping("addPermissionTable")
    public Result<?> addPermissionTablePojo(@RequestBody PermissionTablePojo permissionTablePojo) {
    return permissionTableService.addPermissionTable(permissionTablePojo);
    }
    //新增
    @PostMapping("addPermissionTableS")
    @Transactional
    public Result<?> addPermissionTablePojo(@RequestBody List<PermissionTablePojo> permissionTablePojos) {
        Result<?> result = null;
        for (PermissionTablePojo permissionTablePojo : permissionTablePojos) {
        result = permissionTableService.addPermissionTable(permissionTablePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deletePermissionTable")
    public Result<?> deletePermissionTablePojo(@RequestBody PermissionTablePojo permissionTablePojo) {
        return permissionTableService.deletePermissionTable(permissionTablePojo);
    }

    //修改
    @PostMapping("updatePermissionTable")
    public Result<?> updatePermissionTablePojo(@RequestBody PermissionTablePojo permissionTablePojo) {
        return permissionTableService.updatePermissionTable(permissionTablePojo);
    }

    //查询
    @PostMapping("getPermissionTableList")
    public Result<?> getPermissionTablePojoList(@RequestBody PermissionTablePojo permissionTablePojo) {
        return permissionTableService.getPermissionTableList(permissionTablePojo);
    }


    //分页查询
    @PostMapping("getPermissionTableListPage")
    public Result<?> getPermissionTablePojoListPage(@RequestBody PermissionTablePojo permissionTablePojo) {
        return permissionTableService.getPermissionTableListPage(permissionTablePojo);
    }

}