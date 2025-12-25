package com.yin.module.user.controller;

import com.yin.module.user.entity.UserRoleRelationPojo;
import com.yin.module.user.service.IUserRoleRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 用户角色关联表 前端控制器
 */
@RestController
@RequestMapping("/userRoleRelation")
public class UserRoleRelationController {

    @Autowired
    private IUserRoleRelationService userRoleRelationService;
    /*
        新增
    */
    @PostMapping("addUserRoleRelation")
    public Result<?> addUserRoleRelationPojo(@RequestBody UserRoleRelationPojo userRoleRelationPojo) {
    return userRoleRelationService.addUserRoleRelation(userRoleRelationPojo);
    }
    //新增
    @PostMapping("addUserRoleRelationS")
    @Transactional
    public Result<?> addUserRoleRelationPojo(@RequestBody List<UserRoleRelationPojo> userRoleRelationPojos) {
        Result<?> result = null;
        for (UserRoleRelationPojo userRoleRelationPojo : userRoleRelationPojos) {
        result = userRoleRelationService.addUserRoleRelation(userRoleRelationPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteUserRoleRelation")
    public Result<?> deleteUserRoleRelationPojo(@RequestBody UserRoleRelationPojo userRoleRelationPojo) {
        return userRoleRelationService.deleteUserRoleRelation(userRoleRelationPojo);
    }

    //修改
    @PostMapping("updateUserRoleRelation")
    public Result<?> updateUserRoleRelationPojo(@RequestBody UserRoleRelationPojo userRoleRelationPojo) {
        return userRoleRelationService.updateUserRoleRelation(userRoleRelationPojo);
    }

    //查询
    @PostMapping("getUserRoleRelationList")
    public Result<?> getUserRoleRelationPojoList(@RequestBody UserRoleRelationPojo userRoleRelationPojo) {
        return userRoleRelationService.getUserRoleRelationList(userRoleRelationPojo);
    }


    //分页查询
    @PostMapping("getUserRoleRelationListPage")
    public Result<?> getUserRoleRelationPojoListPage(@RequestBody UserRoleRelationPojo userRoleRelationPojo) {
        return userRoleRelationService.getUserRoleRelationListPage(userRoleRelationPojo);
    }

}