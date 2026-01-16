package com.yin.module.fastReport.service.impl;

import com.yin.module.fastReport.entity.FastreportSqlDatasourcePojo;
import com.yin.module.fastReport.service.IFastreportSqlDatasourceService;
import com.yin.module.fastReport.mapper.FastreportSqlDatasourceMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * FastReport报表SQL数据源表 服务实现类
 */
@Service
public class FastreportSqlDatasourceServiceImpl extends BaseServiceImpl<FastreportSqlDatasourceMapper,FastreportSqlDatasourcePojo> implements IFastreportSqlDatasourceService {

    /**
      常用查询条件
      * @param fastreportSqlDatasourcePojo
    */
    public LambdaQueryWrapper<FastreportSqlDatasourcePojo> fastreportSqlDatasourceLambdaQueryWrapper(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        LambdaQueryWrapper<FastreportSqlDatasourcePojo> fastreportSqlDatasourceLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (fastreportSqlDatasourcePojo.getDatasourceId() != null && !fastreportSqlDatasourcePojo.getDatasourceId().isEmpty()) {
            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getDatasourceId,fastreportSqlDatasourcePojo.getDatasourceId());
        }
        if (fastreportSqlDatasourcePojo.getReportId() != null && !fastreportSqlDatasourcePojo.getReportId().isEmpty()) {
            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getReportId,fastreportSqlDatasourcePojo.getReportId());
        }
        if (fastreportSqlDatasourcePojo.getDatasourceName() != null && !fastreportSqlDatasourcePojo.getDatasourceName().isEmpty()) {
            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getDatasourceName,fastreportSqlDatasourcePojo.getDatasourceName());
        }
//        if (fastreportSqlDatasourcePojo.getSqlContent() != null && !fastreportSqlDatasourcePojo.getSqlContent().isEmpty()) {
//            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getSqlContent,fastreportSqlDatasourcePojo.getSqlContent());
//        }
        if (fastreportSqlDatasourcePojo.getSortNum() != null) {
            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getSortNum,fastreportSqlDatasourcePojo.getSortNum());
        }
        if (fastreportSqlDatasourcePojo.getDelFlag() != null && !fastreportSqlDatasourcePojo.getDelFlag().isEmpty()) {
            fastreportSqlDatasourceLambdaQueryWrapper.eq(FastreportSqlDatasourcePojo::getDelFlag,fastreportSqlDatasourcePojo.getDelFlag());
        }
        return fastreportSqlDatasourceLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param fastreportSqlDatasourcePojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String fastreportSqlDatasourceVerifyS(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo, SysEnum type) {
        if ((fastreportSqlDatasourcePojo.getDatasourceId() == null || fastreportSqlDatasourcePojo.getDatasourceId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "数据源ID（主键）为空";
        }
        if (fastreportSqlDatasourcePojo.getReportId() == null|| fastreportSqlDatasourcePojo.getReportId().isEmpty() ) {
            return "关联报表ID为空";
        }
        if (fastreportSqlDatasourcePojo.getDatasourceName() == null|| fastreportSqlDatasourcePojo.getDatasourceName().isEmpty() ) {
            return "数据源名称为空";
        }
        if (fastreportSqlDatasourcePojo.getSqlContent() == null|| fastreportSqlDatasourcePojo.getSqlContent().isEmpty() ) {
            return "数据源SQL语句为空";
        }
        if (fastreportSqlDatasourcePojo.getSortNum() == null ) {
            return "数据源排序号为空";
        }
        if (fastreportSqlDatasourcePojo.getDelFlag() == null|| fastreportSqlDatasourcePojo.getDelFlag().isEmpty() ) {
            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
    return insert(fastreportSqlDatasourcePojo, fastreportSqlDatasourceVerifyS(fastreportSqlDatasourcePojo, SysEnum.SAVE), fastreportSqlDatasourceLambdaQueryWrapper(fastreportSqlDatasourcePojo));
    }
    //删除
    @Override
    public Result<?> deleteFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
    return delete(fastreportSqlDatasourcePojo, fastreportSqlDatasourceVerifyS(fastreportSqlDatasourcePojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateFastreportSqlDatasource(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
    return update(fastreportSqlDatasourcePojo, fastreportSqlDatasourceVerifyS(fastreportSqlDatasourcePojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<FastreportSqlDatasourcePojo>> getFastreportSqlDatasourceList(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return selectFORList(fastreportSqlDatasourceLambdaQueryWrapper(fastreportSqlDatasourcePojo));
    }
    //分页查询
    @Override
    public Result<Page<FastreportSqlDatasourcePojo>> getFastreportSqlDatasourceListPage(FastreportSqlDatasourcePojo fastreportSqlDatasourcePojo) {
        return selectPage(fastreportSqlDatasourcePojo, fastreportSqlDatasourceLambdaQueryWrapper(fastreportSqlDatasourcePojo));
    }
}