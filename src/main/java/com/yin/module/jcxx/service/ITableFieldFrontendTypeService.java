package com.yin.module.jcxx.service;

import com.yin.module.jcxx.entity.TableFieldFrontendTypePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;

import java.util.List;

/**
 * 前端显示类型配置表 服务接口
 */
public interface ITableFieldFrontendTypeService extends IService<TableFieldFrontendTypePojo> {
    //新增
    public Result<?> addTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo);

    //删除
    public Result<?> deleteTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo);

    //修改
    public Result<?> updateTableFieldFrontendType(TableFieldFrontendTypePojo tableFieldFrontendTypePojo);

    //查询
    public Result<List<TableFieldFrontendTypePojo>> getTableFieldFrontendTypeList(TableFieldFrontendTypePojo tableFieldFrontendTypePojo);

    //分页查询
    public Result<Page<TableFieldFrontendTypePojo>> getTableFieldFrontendTypeListPage(TableFieldFrontendTypePojo tableFieldFrontendTypePojo);
}