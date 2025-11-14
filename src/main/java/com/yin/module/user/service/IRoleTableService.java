package com.yin.module.user.service;

import com.yin.module.user.entity.RoleTablePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
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