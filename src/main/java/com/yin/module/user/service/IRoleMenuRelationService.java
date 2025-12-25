package com.yin.module.user.service;

import com.yin.module.user.entity.RoleMenuRelationPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 与菜单关联表 服务接口
 */
public interface IRoleMenuRelationService extends IService<RoleMenuRelationPojo> {
    //新增
    public Result<?> addRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo);

    //删除
    public Result<?> deleteRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo);

    //修改
    public Result<?> updateRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo) ;

    //查询
    public Result<List<RoleMenuRelationPojo>> getRoleMenuRelationList(RoleMenuRelationPojo roleMenuRelationPojo);

    //分页查询
    public Result<Page<RoleMenuRelationPojo>> getRoleMenuRelationListPage(RoleMenuRelationPojo roleMenuRelationPojo);
}