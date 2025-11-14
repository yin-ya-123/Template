package com.yin.controller;

import com.yin.common.Result;
import com.yin.entity.user.UserTablePojo;
import com.yin.service.user.IUserTableService;
import com.yin.utils.GenericMatchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户表  前端控制器
 */
@RestController
@RequestMapping("/userTable")
public class UserTableController {

    @Autowired
    private IUserTableService userTableService;

    /*
        新增
    */
    @PostMapping("addUserTable")
    public Result<?> addUserTablePojo(@RequestBody UserTablePojo userTablePojo) {
        return userTableService.addUserTable(userTablePojo);
    }

    //新增
    @PostMapping("addUserTableS")
    @Transactional
    public Result<?> addUserTablePojo(@RequestBody List<UserTablePojo> userTablePojos) {
        Result<?> result = null;
        for (UserTablePojo userTablePojo : userTablePojos) {
            result = userTableService.addUserTable(userTablePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteUserTable")
    public Result<?> deleteUserTablePojo(@RequestBody UserTablePojo userTablePojo) {
        return userTableService.deleteUserTable(userTablePojo);
    }

    //修改
    @PostMapping("updateUserTable")
    public Result<?> updateUserTablePojo(@RequestBody UserTablePojo userTablePojo) {
        return userTableService.updateUserTable(userTablePojo);
    }

    //查询
    @PostMapping("getUserTableList")
    public Result<?> getUserTablePojoList(@RequestBody UserTablePojo userTablePojo) {
        GenericMatchUtils.isMatch(userTablePojo, UserTablePojo.class);
        return userTableService.getUserTableList(userTablePojo);
    }


    //分页查询
    @PostMapping("getUserTableListPage")
    public Result<?> getUserTablePojoListPage(@RequestBody UserTablePojo userTablePojo) {
        return userTableService.getUserTableListPage(userTablePojo);
    }

}