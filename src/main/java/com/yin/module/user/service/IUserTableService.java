package com.yin.module.user.service;

import com.yin.module.user.entity.UserTablePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 *  用户表  服务接口
 */
public interface IUserTableService extends IService<UserTablePojo> {
    //新增
    public Result<?> addUserTable(UserTablePojo userTablePojo);

    //删除
    public Result<?> deleteUserTable(UserTablePojo userTablePojo);

    //修改
    public Result<?> updateUserTable(UserTablePojo userTablePojo) ;

    //查询
    public Result<List<UserTablePojo>> getUserTableList(UserTablePojo userTablePojo);

    //分页查询
    public Result<Page<UserTablePojo>> getUserTableListPage(UserTablePojo userTablePojo);
}