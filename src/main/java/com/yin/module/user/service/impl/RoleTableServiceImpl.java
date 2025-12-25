package com.yin.module.user.service.impl;

import com.yin.module.user.entity.RoleTablePojo;
import com.yin.module.user.service.IRoleTableService;
import com.yin.module.user.mapper.RoleTableMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 角色表 服务实现类
 */
@Service
public class RoleTableServiceImpl extends BaseServiceImpl<RoleTableMapper,RoleTablePojo> implements IRoleTableService {

    /**
      常用查询条件
      * @param roleTablePojo
    */
    public LambdaQueryWrapper<RoleTablePojo> roleTableLambdaQueryWrapper(RoleTablePojo roleTablePojo) {
        LambdaQueryWrapper<RoleTablePojo> roleTableLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (roleTablePojo.getId() != null && !roleTablePojo.getId().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getId,roleTablePojo.getId());
        }
        if (roleTablePojo.getRoleName() != null && !roleTablePojo.getRoleName().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getRoleName,roleTablePojo.getRoleName());
        }
        if (roleTablePojo.getRoleDesc() != null && !roleTablePojo.getRoleDesc().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getRoleDesc,roleTablePojo.getRoleDesc());
        }
        if (roleTablePojo.getPym() != null && !roleTablePojo.getPym().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getPym,roleTablePojo.getPym());
        }
        if (roleTablePojo.getSort() != null && !roleTablePojo.getSort().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getSort,roleTablePojo.getSort());
        }
        if (roleTablePojo.getDelFlag() != null && !roleTablePojo.getDelFlag().isEmpty()) {
            roleTableLambdaQueryWrapper.eq(RoleTablePojo::getDelFlag,roleTablePojo.getDelFlag());
        }
        return roleTableLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param roleTablePojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String roleTableVerifyS(RoleTablePojo roleTablePojo, SysEnum type) {
        if ((roleTablePojo.getId() == null || roleTablePojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "主键 ID为空";
        }
        if (roleTablePojo.getRoleName() == null || roleTablePojo.getRoleName().isEmpty()) {
            return "角色名称 为空";
        }
        if (roleTablePojo.getRoleDesc() == null || roleTablePojo.getRoleDesc().isEmpty()) {
            return "角色描述 为空";
        }
        if (roleTablePojo.getPym() == null || roleTablePojo.getPym().isEmpty()) {
            return "拼音码 / 助记码 为空";
        }
        if (roleTablePojo.getSort() == null || roleTablePojo.getSort().isEmpty()) {
            return "排序字段 为空";
        }
        if (roleTablePojo.getDelFlag() == null || roleTablePojo.getDelFlag().isEmpty()) {
            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addRoleTable(RoleTablePojo roleTablePojo) {
    return insert(roleTablePojo, roleTableVerifyS(roleTablePojo, SysEnum.SAVE), roleTableLambdaQueryWrapper(roleTablePojo));
    }
    //删除
    @Override
    public Result<?> deleteRoleTable(RoleTablePojo roleTablePojo) {
    return delete(roleTablePojo, roleTableVerifyS(roleTablePojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateRoleTable(RoleTablePojo roleTablePojo) {
    return update(roleTablePojo, roleTableVerifyS(roleTablePojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<RoleTablePojo>> getRoleTableList(RoleTablePojo roleTablePojo) {
        return selectFORList(roleTableLambdaQueryWrapper(roleTablePojo));
    }
    //分页查询
    @Override
    public Result<Page<RoleTablePojo>> getRoleTableListPage(RoleTablePojo roleTablePojo) {
        return selectPage(roleTablePojo, roleTableLambdaQueryWrapper(roleTablePojo));
    }
}