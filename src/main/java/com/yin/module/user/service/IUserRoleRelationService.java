package com.yin.module.user.service;

import com.yin.module.user.entity.UserRoleRelationPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 用户角色关联表 服务接口
 */
public interface IUserRoleRelationService extends IService<UserRoleRelationPojo> {
    //新增
    public Result<?> addUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo);

    //删除
    public Result<?> deleteUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo);

    //修改
    public Result<?> updateUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo) ;

    //查询
    public Result<List<UserRoleRelationPojo>> getUserRoleRelationList(UserRoleRelationPojo userRoleRelationPojo);

    //分页查询
    public Result<Page<UserRoleRelationPojo>> getUserRoleRelationListPage(UserRoleRelationPojo userRoleRelationPojo);
}