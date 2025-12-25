package com.yin.module.user.controller;

import com.yin.module.user.entity.RoleTablePojo;
import com.yin.module.user.service.IRoleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 角色表 前端控制器
 */
@RestController
@RequestMapping("/roleTable")
public class RoleTableController {

    @Autowired
    private IRoleTableService roleTableService;
    /*
        新增
    */
    @PostMapping("addRoleTable")
    public Result<?> addRoleTablePojo(@RequestBody RoleTablePojo roleTablePojo) {
    return roleTableService.addRoleTable(roleTablePojo);
    }
    //新增
    @PostMapping("addRoleTableS")
    @Transactional
    public Result<?> addRoleTablePojo(@RequestBody List<RoleTablePojo> roleTablePojos) {
        Result<?> result = null;
        for (RoleTablePojo roleTablePojo : roleTablePojos) {
        result = roleTableService.addRoleTable(roleTablePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteRoleTable")
    public Result<?> deleteRoleTablePojo(@RequestBody RoleTablePojo roleTablePojo) {
        return roleTableService.deleteRoleTable(roleTablePojo);
    }

    //修改
    @PostMapping("updateRoleTable")
    public Result<?> updateRoleTablePojo(@RequestBody RoleTablePojo roleTablePojo) {
        return roleTableService.updateRoleTable(roleTablePojo);
    }

    //查询
    @PostMapping("getRoleTableList")
    public Result<?> getRoleTablePojoList(@RequestBody RoleTablePojo roleTablePojo) {
        return roleTableService.getRoleTableList(roleTablePojo);
    }


    //分页查询
    @PostMapping("getRoleTableListPage")
    public Result<?> getRoleTablePojoListPage(@RequestBody RoleTablePojo roleTablePojo) {
        return roleTableService.getRoleTableListPage(roleTablePojo);
    }

}