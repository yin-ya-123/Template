package com.yin.module.user.service.impl;

import com.yin.module.user.entity.PermissionTablePojo;
import com.yin.module.user.service.IPermissionTableService;
import com.yin.module.user.mapper.PermissionTableMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 权限表 服务实现类
 */
@Service
public class PermissionTableServiceImpl extends BaseServiceImpl<PermissionTableMapper, PermissionTablePojo> implements IPermissionTableService {

    /**
     * 常用查询条件
     *
     * @param permissionTablePojo
     */
    public LambdaQueryWrapper<PermissionTablePojo> permissionTableLambdaQueryWrapper(PermissionTablePojo permissionTablePojo) {
        LambdaQueryWrapper<PermissionTablePojo> permissionTableLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (permissionTablePojo.getId() != null && !permissionTablePojo.getId().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getId, permissionTablePojo.getId());
        }
        if (permissionTablePojo.getPermissionName() != null && !permissionTablePojo.getPermissionName().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getPermissionName, permissionTablePojo.getPermissionName());
        }
        if (permissionTablePojo.getPermissionDesc() != null && !permissionTablePojo.getPermissionDesc().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getPermissionDesc, permissionTablePojo.getPermissionDesc());
        }
        if (permissionTablePojo.getPym() != null && !permissionTablePojo.getPym().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getPym, permissionTablePojo.getPym());
        }
        if (permissionTablePojo.getSort() != null && !permissionTablePojo.getSort().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getSort, permissionTablePojo.getSort());
        }
        if (permissionTablePojo.getDelFlag() != null && !permissionTablePojo.getDelFlag().isEmpty()) {
            permissionTableLambdaQueryWrapper.eq(PermissionTablePojo::getDelFlag, permissionTablePojo.getDelFlag());
        }
        return permissionTableLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param permissionTablePojo 实体
     * @param type                操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String permissionTableVerifyS(PermissionTablePojo permissionTablePojo, SysEnum type) {
        if ((permissionTablePojo.getId() == null || permissionTablePojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "主键 ID为空";
        }
        if (permissionTablePojo.getPermissionName() == null || permissionTablePojo.getPermissionName().isEmpty()) {
            return "权限名称 为空";
        }
        if (permissionTablePojo.getPermissionDesc() == null || permissionTablePojo.getPermissionDesc().isEmpty()) {
            return "权限描述 为空";
        }
        if (permissionTablePojo.getPym() == null || permissionTablePojo.getPym().isEmpty()) {
            return "拼音码 / 助记码 为空";
        }
        if (permissionTablePojo.getSort() == null || permissionTablePojo.getSort().isEmpty()) {
            return "排序字段 为空";
        }
        if (permissionTablePojo.getDelFlag() == null || permissionTablePojo.getDelFlag().isEmpty()) {
            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addPermissionTable(PermissionTablePojo permissionTablePojo) {
        return insert(permissionTablePojo, permissionTableVerifyS(permissionTablePojo, SysEnum.SAVE), permissionTableLambdaQueryWrapper(permissionTablePojo));
    }

    //删除
    @Override
    public Result<?> deletePermissionTable(PermissionTablePojo permissionTablePojo) {
        return delete(permissionTablePojo, permissionTableVerifyS(permissionTablePojo, SysEnum.DELETE));
    }

    //修改
    @Override
    public Result<?> updatePermissionTable(PermissionTablePojo permissionTablePojo) {
        return update(permissionTablePojo, permissionTableVerifyS(permissionTablePojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<PermissionTablePojo>> getPermissionTableList(PermissionTablePojo permissionTablePojo) {
        return selectFORList(permissionTableLambdaQueryWrapper(permissionTablePojo));
    }

    //分页查询
    @Override
    public Result<Page<PermissionTablePojo>> getPermissionTableListPage(PermissionTablePojo permissionTablePojo) {
        return selectPage(permissionTablePojo, permissionTableLambdaQueryWrapper(permissionTablePojo));
    }
}