package com.yin.module.fastReport.service.impl;

import com.yin.module.fastReport.entity.FastreportMainPojo;
import com.yin.module.fastReport.service.IFastreportMainService;
import com.yin.module.fastReport.mapper.FastreportMainMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * FastReport报表主表 服务实现类
 */
@Service
public class FastreportMainServiceImpl extends BaseServiceImpl<FastreportMainMapper,FastreportMainPojo> implements IFastreportMainService {

    /**
      常用查询条件
      * @param fastreportMainPojo
    */
    public LambdaQueryWrapper<FastreportMainPojo> fastreportMainLambdaQueryWrapper(FastreportMainPojo fastreportMainPojo) {
        LambdaQueryWrapper<FastreportMainPojo> fastreportMainLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (fastreportMainPojo.getReportId() != null && !fastreportMainPojo.getReportId().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getReportId,fastreportMainPojo.getReportId());
        }
        if (fastreportMainPojo.getReportName() != null && !fastreportMainPojo.getReportName().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getReportName,fastreportMainPojo.getReportName());
        }
        if (fastreportMainPojo.getReportCode() != null && !fastreportMainPojo.getReportCode().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getReportCode,fastreportMainPojo.getReportCode());
        }
        if (fastreportMainPojo.getTemplateContent() != null) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getTemplateContent,fastreportMainPojo.getTemplateContent());
        }
        if (fastreportMainPojo.getTemplateDesc() != null && !fastreportMainPojo.getTemplateDesc().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getTemplateDesc,fastreportMainPojo.getTemplateDesc());
        }
        if (fastreportMainPojo.getStatus() != null && !fastreportMainPojo.getStatus().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getStatus,fastreportMainPojo.getStatus());
        }
        if (fastreportMainPojo.getDelFlag() != null && !fastreportMainPojo.getDelFlag().isEmpty()) {
            fastreportMainLambdaQueryWrapper.eq(FastreportMainPojo::getDelFlag,fastreportMainPojo.getDelFlag());
        }
        return fastreportMainLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param fastreportMainPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String fastreportMainVerifyS(FastreportMainPojo fastreportMainPojo, SysEnum type) {
        if ((fastreportMainPojo.getReportId() == null|| fastreportMainPojo.getReportId().isEmpty())&& (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt())) ) {
            return "报表ID（主键）为空";
        }
        if (fastreportMainPojo.getReportName() == null|| fastreportMainPojo.getReportName().isEmpty() ) {
            return "报表名称为空";
        }
        if (fastreportMainPojo.getReportCode() == null|| fastreportMainPojo.getReportCode().isEmpty() ) {
            return "报表编码（唯一）为空";
        }
        if (fastreportMainPojo.getTemplateDesc() == null|| fastreportMainPojo.getTemplateDesc().isEmpty() ) {
            return "报表模板描述为空";
        }
        if (fastreportMainPojo.getStatus() == null|| fastreportMainPojo.getStatus().isEmpty() ) {
            return "报表状态（1:启用 0:禁用）为空";
        }
        if (fastreportMainPojo.getDelFlag() == null|| fastreportMainPojo.getDelFlag().isEmpty() ) {
            return "逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addFastreportMain(FastreportMainPojo fastreportMainPojo) {
    return insert(fastreportMainPojo, fastreportMainVerifyS(fastreportMainPojo, SysEnum.SAVE), fastreportMainLambdaQueryWrapper(fastreportMainPojo));
    }
    //删除
    @Override
    public Result<?> deleteFastreportMain(FastreportMainPojo fastreportMainPojo) {
    return delete(fastreportMainPojo, fastreportMainVerifyS(fastreportMainPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateFastreportMain(FastreportMainPojo fastreportMainPojo) {
    return update(fastreportMainPojo, fastreportMainVerifyS(fastreportMainPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<FastreportMainPojo>> getFastreportMainList(FastreportMainPojo fastreportMainPojo) {
        return selectFORList(fastreportMainLambdaQueryWrapper(fastreportMainPojo));
    }
    //分页查询
    @Override
    public Result<Page<FastreportMainPojo>> getFastreportMainListPage(FastreportMainPojo fastreportMainPojo) {
        return selectPage(fastreportMainPojo, fastreportMainLambdaQueryWrapper(fastreportMainPojo));
    }
}