package com.yin.module.user.controller;

import com.yin.module.user.entity.RoleMenuRelationPojo;
import com.yin.module.user.service.IRoleMenuRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 与菜单关联表 前端控制器
 */
@RestController
@RequestMapping("/roleMenuRelation")
public class RoleMenuRelationController {

    @Autowired
    private IRoleMenuRelationService roleMenuRelationService;
    /*
        新增
    */
    @PostMapping("addRoleMenuRelation")
    public Result<?> addRoleMenuRelationPojo(@RequestBody RoleMenuRelationPojo roleMenuRelationPojo) {
    return roleMenuRelationService.addRoleMenuRelation(roleMenuRelationPojo);
    }
    //新增
    @PostMapping("addRoleMenuRelationS")
    @Transactional
    public Result<?> addRoleMenuRelationPojo(@RequestBody List<RoleMenuRelationPojo> roleMenuRelationPojos) {
        Result<?> result = null;
        for (RoleMenuRelationPojo roleMenuRelationPojo : roleMenuRelationPojos) {
        result = roleMenuRelationService.addRoleMenuRelation(roleMenuRelationPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteRoleMenuRelation")
    public Result<?> deleteRoleMenuRelationPojo(@RequestBody RoleMenuRelationPojo roleMenuRelationPojo) {
        return roleMenuRelationService.deleteRoleMenuRelation(roleMenuRelationPojo);
    }

    //修改
    @PostMapping("updateRoleMenuRelation")
    public Result<?> updateRoleMenuRelationPojo(@RequestBody RoleMenuRelationPojo roleMenuRelationPojo) {
        return roleMenuRelationService.updateRoleMenuRelation(roleMenuRelationPojo);
    }

    //查询
    @PostMapping("getRoleMenuRelationList")
    public Result<?> getRoleMenuRelationPojoList(@RequestBody RoleMenuRelationPojo roleMenuRelationPojo) {
        return roleMenuRelationService.getRoleMenuRelationList(roleMenuRelationPojo);
    }


    //分页查询
    @PostMapping("getRoleMenuRelationListPage")
    public Result<?> getRoleMenuRelationPojoListPage(@RequestBody RoleMenuRelationPojo roleMenuRelationPojo) {
        return roleMenuRelationService.getRoleMenuRelationListPage(roleMenuRelationPojo);
    }

}