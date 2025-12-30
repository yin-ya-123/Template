package com.yin.module.jcxx.service.impl;

import com.yin.module.jcxx.entity.TableFieldFrontendTypePojo;
import com.yin.module.jcxx.service.ITableFieldFrontendTypeService;
import com.yin.module.jcxx.mapper.TableFieldFrontendTypeMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 前端显示类型配置表 服务实现类
 */
@Service
public class TableFieldFrontendTypeServiceImpl extends BaseServiceImpl<TableFieldFrontendTypeMapper, TableFieldFrontendTypePojo> implements ITableFieldFrontendTypeService {

    /**
     * 常用查询条件
     *
     * @param tableFieldFrontendTypePojo
     */
    public LambdaQueryWrapper<TableFieldFrontendTypePojo> tableFieldFrontendTypeLambdaQueryWrapper(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        LambdaQueryWrapper<TableFieldFrontendTypePojo> tableFieldFrontendTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (tableFieldFrontendTypePojo.getId() != null && !tableFieldFrontendTypePojo.getId().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getId, tableFieldFrontendTypePojo.getId());
        }
        if (tableFieldFrontendTypePojo.getTableName() != null && !tableFieldFrontendTypePojo.getTableName().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getTableName, tableFieldFrontendTypePojo.getTableName());
        }
        if (tableFieldFrontendTypePojo.getFieldName() != null && !tableFieldFrontendTypePojo.getFieldName().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getFieldName, tableFieldFrontendTypePojo.getFieldName());
        }
        if (tableFieldFrontendTypePojo.getFrontendType() != null && !tableFieldFrontendTypePojo.getFrontendType().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getFrontendType, tableFieldFrontendTypePojo.getFrontendType());
        }
        if (tableFieldFrontendTypePojo.getJsonValue() != null && !tableFieldFrontendTypePojo.getJsonValue().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getJsonValue, tableFieldFrontendTypePojo.getJsonValue());
        }
        if (tableFieldFrontendTypePojo.getDelFlag() != null && !tableFieldFrontendTypePojo.getDelFlag().isEmpty()) {
            tableFieldFrontendTypeLambdaQueryWrapper.eq(TableFieldFrontendTypePojo::getDelFlag, tableFieldFrontendTypePojo.getDelFlag());
        }
        tableFieldFrontendTypeLambdaQueryWrapper.orderByAsc(
                TableFieldFrontendTypePojo::getSort,
                TableFieldFrontendTypePojo::getFieldName,
                TableFieldFrontendTypePojo::getTableName
                );
        return tableFieldFrontendTypeLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param tableFieldFrontendTypePojo 实体
     * @param type                       操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String tableFieldFrontendTypeVerifyS(TableFieldFrontendTypePojo tableFieldFrontendTypePojo, SysEnum type) {
        if ((tableFieldFrontendTypePojo.getId() == null || tableFieldFrontendTypePojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "主键ID为空";
        }
        if (tableFieldFrontendTypePojo.getTableName() == null || tableFieldFrontendTypePojo.getTableName().isEmpty()) {
            return "表名称为空";
        }
        if (tableFieldFrontendTypePojo.getFieldName() == null || tableFieldFrontendTypePojo.getFieldName().isEmpty()) {
            return "字段名称为空";
        }
        if (tableFieldFrontendTypePojo.getFrontendType() == null || tableFieldFrontendTypePojo.getFrontendType().isEmpty()) {
            return "前端显示组件类型为空";
        }
        if (tableFieldFrontendTypePojo.getJsonValue() == null || tableFieldFrontendTypePojo.getJsonValue().isEmpty()) {
            return "字段对应的JSON数据为空";
        }
        if (tableFieldFrontendTypePojo.getDelFlag() == null || tableFieldFrontendTypePojo.getDelFlag().isEmpty()) {
            return "逻辑删除标志0未删除1已删除为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return insert(tableFieldFrontendTypePojo, tableFieldFrontendTypeVerifyS(tableFieldFrontendTypePojo, SysEnum.SAVE), tableFieldFrontendTypeLambdaQueryWrapper(tableFieldFrontendTypePojo));
    }

    //删除
    @Override
    public Result<?> deleteTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return delete(tableFieldFrontendTypePojo, tableFieldFrontendTypeVerifyS(tableFieldFrontendTypePojo, SysEnum.DELETE));
    }

    //修改
    @Override
    public Result<?> updateTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return update(tableFieldFrontendTypePojo, tableFieldFrontendTypeVerifyS(tableFieldFrontendTypePojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<TableFieldFrontendTypePojo>> getTableFieldFrontendTypeList(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return selectFORList(tableFieldFrontendTypeLambdaQueryWrapper(tableFieldFrontendTypePojo));
    }

    //分页查询
    @Override
    public Result<Page<TableFieldFrontendTypePojo>> getTableFieldFrontendTypeListPage(TableFieldFrontendTypePojo tableFieldFrontendTypePojo) {
        return selectPage(tableFieldFrontendTypePojo, tableFieldFrontendTypeLambdaQueryWrapper(tableFieldFrontendTypePojo));
    }
}