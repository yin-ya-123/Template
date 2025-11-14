package com.yin.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yin.common.Result;
import com.yin.entity.user.RoleTablePojo;

import java.util.List;

/**
 *  角色表  服务接口
 */
public interface IRoleTableService extends IService<RoleTablePojo> {
    //新增
    public Result<?> addRoleTable(RoleTablePojo roleTablePojo);

    //删除
    public Result<?> deleteRoleTable(RoleTablePojo roleTablePojo);

    //修改
    public Result<?> updateRoleTable(RoleTablePojo roleTablePojo) ;

    //查询
    public Result<List<RoleTablePojo>> getRoleTableList(RoleTablePojo roleTablePojo);

    //分页查询
    public Result<Page<RoleTablePojo>> getRoleTableListPage(RoleTablePojo roleTablePojo);
}