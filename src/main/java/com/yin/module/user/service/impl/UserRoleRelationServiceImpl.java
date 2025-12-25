package com.yin.module.user.service.impl;

import com.yin.module.user.entity.UserRoleRelationPojo;
import com.yin.module.user.service.IUserRoleRelationService;
import com.yin.module.user.mapper.UserRoleRelationMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 用户角色关联表 服务实现类
 */
@Service
public class UserRoleRelationServiceImpl extends BaseServiceImpl<UserRoleRelationMapper,UserRoleRelationPojo> implements IUserRoleRelationService {

    /**
      常用查询条件
      * @param userRoleRelationPojo
    */
    public LambdaQueryWrapper<UserRoleRelationPojo> userRoleRelationLambdaQueryWrapper(UserRoleRelationPojo userRoleRelationPojo) {
        LambdaQueryWrapper<UserRoleRelationPojo> userRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (userRoleRelationPojo.getId() != null && !userRoleRelationPojo.getId().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getId,userRoleRelationPojo.getId());
        }
        if (userRoleRelationPojo.getUserId() != null && !userRoleRelationPojo.getUserId().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getUserId,userRoleRelationPojo.getUserId());
        }
        if (userRoleRelationPojo.getUserName() != null && !userRoleRelationPojo.getUserName().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getUserName,userRoleRelationPojo.getUserName());
        }
        if (userRoleRelationPojo.getRoleId() != null && !userRoleRelationPojo.getRoleId().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getRoleId,userRoleRelationPojo.getRoleId());
        }
        if (userRoleRelationPojo.getRoleName() != null && !userRoleRelationPojo.getRoleName().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getRoleName,userRoleRelationPojo.getRoleName());
        }
        if (userRoleRelationPojo.getPym() != null && !userRoleRelationPojo.getPym().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getPym,userRoleRelationPojo.getPym());
        }
        if (userRoleRelationPojo.getSort() != null && !userRoleRelationPojo.getSort().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getSort,userRoleRelationPojo.getSort());
        }
        if (userRoleRelationPojo.getDelFlag() != null && !userRoleRelationPojo.getDelFlag().isEmpty()) {
            userRoleRelationLambdaQueryWrapper.eq(UserRoleRelationPojo::getDelFlag,userRoleRelationPojo.getDelFlag());
        }
        return userRoleRelationLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param userRoleRelationPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String userRoleRelationVerifyS(UserRoleRelationPojo userRoleRelationPojo, SysEnum type) {
        if ((userRoleRelationPojo.getId() == null || userRoleRelationPojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "主键 ID为空";
        }
        if (userRoleRelationPojo.getUserId() == null || userRoleRelationPojo.getUserId().isEmpty()) {
            return "用户 ID为空";
        }
        if (userRoleRelationPojo.getUserName() == null || userRoleRelationPojo.getUserName().isEmpty()) {
            return "用户名称为空";
        }
        if (userRoleRelationPojo.getRoleId() == null || userRoleRelationPojo.getRoleId().isEmpty()) {
            return "角色 ID为空";
        }
        if (userRoleRelationPojo.getRoleName() == null || userRoleRelationPojo.getRoleName().isEmpty()) {
            return "角色名称为空";
        }
        if (userRoleRelationPojo.getDelFlag() == null || userRoleRelationPojo.getDelFlag().isEmpty()) {
            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo) {
    return insert(userRoleRelationPojo, userRoleRelationVerifyS(userRoleRelationPojo, SysEnum.SAVE), userRoleRelationLambdaQueryWrapper(userRoleRelationPojo));
    }
    //删除
    @Override
    public Result<?> deleteUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo) {
    return delete(userRoleRelationPojo, userRoleRelationVerifyS(userRoleRelationPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateUserRoleRelation(UserRoleRelationPojo userRoleRelationPojo) {
    return update(userRoleRelationPojo, userRoleRelationVerifyS(userRoleRelationPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<UserRoleRelationPojo>> getUserRoleRelationList(UserRoleRelationPojo userRoleRelationPojo) {
        return selectFORList(userRoleRelationLambdaQueryWrapper(userRoleRelationPojo));
    }
    //分页查询
    @Override
    public Result<Page<UserRoleRelationPojo>> getUserRoleRelationListPage(UserRoleRelationPojo userRoleRelationPojo) {
        return selectPage(userRoleRelationPojo, userRoleRelationLambdaQueryWrapper(userRoleRelationPojo));
    }
}