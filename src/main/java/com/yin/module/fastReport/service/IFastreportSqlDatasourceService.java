package com.yin.module.fastReport.service;

import com.yin.module.fastReport.entity.FastreportSqlDatasourcePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * FastReport报表SQL数据源表 服务接口
 */
public interface IFastreportSqlDatasourceService extends IService<FastreportSqlDatasourcePojo> {
    //新增
    public Result<?> addFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo);

    //删除
    public Result<?> deleteFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo);

    //修改
    public Result<?> updateFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) ;

    //查询
    public Result<List<FastreportSqlDatasourcePojo>> getFastreportSqlDatasourceList(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo);

    //分页查询
    public Result<Page<FastreportSqlDatasourcePojo>> getFastreportSqlDatasourceListPage(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo);
}