package com.yin.module.user.service;

import com.yin.module.user.entity.PermissionTablePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 权限表 服务接口
 */
public interface IPermissionTableService extends IService<PermissionTablePojo> {
    //新增
    public Result<?> addPermissionTable(PermissionTablePojo permissionTablePojo);

    //删除
    public Result<?> deletePermissionTable(PermissionTablePojo permissionTablePojo);

    //修改
    public Result<?> updatePermissionTable(PermissionTablePojo permissionTablePojo) ;

    //查询
    public Result<List<PermissionTablePojo>> getPermissionTableList(PermissionTablePojo permissionTablePojo);

    //分页查询
    public Result<Page<PermissionTablePojo>> getPermissionTableListPage(PermissionTablePojo permissionTablePojo);
}