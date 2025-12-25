package com.yin.module.user.service.impl;

import com.yin.module.user.entity.RoleMenuRelationPojo;
import com.yin.module.user.service.IRoleMenuRelationService;
import com.yin.module.user.mapper.RoleMenuRelationMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 与菜单关联表 服务实现类
 */
@Service
public class RoleMenuRelationServiceImpl extends BaseServiceImpl<RoleMenuRelationMapper, RoleMenuRelationPojo> implements IRoleMenuRelationService {

    /**
     * 常用查询条件
     *
     * @param roleMenuRelationPojo
     */
    public LambdaQueryWrapper<RoleMenuRelationPojo> roleMenuRelationLambdaQueryWrapper(RoleMenuRelationPojo roleMenuRelationPojo) {
        LambdaQueryWrapper<RoleMenuRelationPojo> roleMenuRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (roleMenuRelationPojo.getId() != null && !roleMenuRelationPojo.getId().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getId, roleMenuRelationPojo.getId());
        }
        if (roleMenuRelationPojo.getRoleId() != null && !roleMenuRelationPojo.getRoleId().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getRoleId, roleMenuRelationPojo.getRoleId());
        }
        if (roleMenuRelationPojo.getRoleName() != null && !roleMenuRelationPojo.getRoleName().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getRoleName, roleMenuRelationPojo.getRoleName());
        }
        if (roleMenuRelationPojo.getMenuId() != null && !roleMenuRelationPojo.getMenuId().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getMenuId, roleMenuRelationPojo.getMenuId());
        }
        if (roleMenuRelationPojo.getMenuName() != null && !roleMenuRelationPojo.getMenuName().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getMenuName, roleMenuRelationPojo.getMenuName());
        }
        if (roleMenuRelationPojo.getPym() != null && !roleMenuRelationPojo.getPym().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getPym, roleMenuRelationPojo.getPym());
        }
        if (roleMenuRelationPojo.getSort() != null && !roleMenuRelationPojo.getSort().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getSort, roleMenuRelationPojo.getSort());
        }
        if (roleMenuRelationPojo.getDelFlag() != null && !roleMenuRelationPojo.getDelFlag().isEmpty()) {
            roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelationPojo::getDelFlag, roleMenuRelationPojo.getDelFlag());
        }
        return roleMenuRelationLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param roleMenuRelationPojo 实体
     * @param type                 操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String roleMenuRelationVerifyS(RoleMenuRelationPojo roleMenuRelationPojo, SysEnum type) {
//        if ((roleMenuRelationPojo.getId() == null || roleMenuRelationPojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
//            return "主键 ID为空";
//        }
//        if (roleMenuRelationPojo.getRoleId() == null || roleMenuRelationPojo.getRoleId().isEmpty()) {
//            return "角色ID为空";
//        }
//        if (roleMenuRelationPojo.getRoleName() == null || roleMenuRelationPojo.getRoleName().isEmpty()) {
//            return "角色名称为空";
//        }
//        if (roleMenuRelationPojo.getMenuId() == null || roleMenuRelationPojo.getMenuId().isEmpty()) {
//            return "菜单 ID为空";
//        }
//        if (roleMenuRelationPojo.getMenuName() == null || roleMenuRelationPojo.getMenuName().isEmpty()) {
//            return "菜单名称为空";
//        }
//        if (roleMenuRelationPojo.getDelFlag() == null || roleMenuRelationPojo.getDelFlag().isEmpty()) {
//            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
//        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo) {
        return insert(roleMenuRelationPojo, roleMenuRelationVerifyS(roleMenuRelationPojo, SysEnum.SAVE), roleMenuRelationLambdaQueryWrapper(roleMenuRelationPojo));
    }

    //删除
    @Override
    public Result<?> deleteRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo) {
        return delete(roleMenuRelationPojo, roleMenuRelationVerifyS(roleMenuRelationPojo, SysEnum.DELETE), roleMenuRelationLambdaQueryWrapper(roleMenuRelationPojo));
    }

    //修改
    @Override
    public Result<?> updateRoleMenuRelation(RoleMenuRelationPojo roleMenuRelationPojo) {
        return update(roleMenuRelationPojo, roleMenuRelationVerifyS(roleMenuRelationPojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<RoleMenuRelationPojo>> getRoleMenuRelationList(RoleMenuRelationPojo roleMenuRelationPojo) {
        return selectFORList(roleMenuRelationLambdaQueryWrapper(roleMenuRelationPojo));
    }

    //分页查询
    @Override
    public Result<Page<RoleMenuRelationPojo>> getRoleMenuRelationListPage(RoleMenuRelationPojo roleMenuRelationPojo) {
        return selectPage(roleMenuRelationPojo, roleMenuRelationLambdaQueryWrapper(roleMenuRelationPojo));
    }
}