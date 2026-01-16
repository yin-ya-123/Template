package com.yin.module.fastReport.service.impl;

import com.yin.module.fastReport.entity.FastreportParamPojo;
import com.yin.module.fastReport.service.IFastreportParamService;
import com.yin.module.fastReport.mapper.FastreportParamMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * FastReport报表参数信息表 服务实现类
 */
@Service
public class FastreportParamServiceImpl extends BaseServiceImpl<FastreportParamMapper,FastreportParamPojo> implements IFastreportParamService {

    /**
      常用查询条件
      * @param fastreportParamPojo
    */
    public LambdaQueryWrapper<FastreportParamPojo> fastreportParamLambdaQueryWrapper(FastreportParamPojo fastreportParamPojo) {
        LambdaQueryWrapper<FastreportParamPojo> fastreportParamLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (fastreportParamPojo.getParamId() != null && !fastreportParamPojo.getParamId().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getParamId,fastreportParamPojo.getParamId());
        }
        if (fastreportParamPojo.getReportId() != null && !fastreportParamPojo.getReportId().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getReportId,fastreportParamPojo.getReportId());
        }
        if (fastreportParamPojo.getParamName() != null && !fastreportParamPojo.getParamName().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getParamName,fastreportParamPojo.getParamName());
        }
        if (fastreportParamPojo.getParamCode() != null && !fastreportParamPojo.getParamCode().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getParamCode,fastreportParamPojo.getParamCode());
        }
        if (fastreportParamPojo.getParamType() != null && !fastreportParamPojo.getParamType().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getParamType,fastreportParamPojo.getParamType());
        }
        if (fastreportParamPojo.getDefaultValue() != null && !fastreportParamPojo.getDefaultValue().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getDefaultValue,fastreportParamPojo.getDefaultValue());
        }
        if (fastreportParamPojo.getParamDesc() != null && !fastreportParamPojo.getParamDesc().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getParamDesc,fastreportParamPojo.getParamDesc());
        }
        if (fastreportParamPojo.getIsRequired() != null && !fastreportParamPojo.getIsRequired().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getIsRequired,fastreportParamPojo.getIsRequired());
        }
        if (fastreportParamPojo.getSortNum() != null) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getSortNum,fastreportParamPojo.getSortNum());
        }
        if (fastreportParamPojo.getDelFlag() != null && !fastreportParamPojo.getDelFlag().isEmpty()) {
            fastreportParamLambdaQueryWrapper.eq(FastreportParamPojo::getDelFlag,fastreportParamPojo.getDelFlag());
        }
        return fastreportParamLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param fastreportParamPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String fastreportParamVerifyS(FastreportParamPojo fastreportParamPojo, SysEnum type) {
        if ((fastreportParamPojo.getParamId() == null || fastreportParamPojo.getParamId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "参数ID（主键）为空";
        }
        if (fastreportParamPojo.getReportId() == null|| fastreportParamPojo.getReportId().isEmpty() ) {
            return "关联报表主表的REPORT_ID为空";
        }
        if (fastreportParamPojo.getParamName() == null|| fastreportParamPojo.getParamName().isEmpty() ) {
            return "参数名称为空";
        }
        if (fastreportParamPojo.getParamCode() == null|| fastreportParamPojo.getParamCode().isEmpty() ) {
            return "参数编码（同一报表下唯一）为空";
        }
        if (fastreportParamPojo.getParamType() == null|| fastreportParamPojo.getParamType().isEmpty() ) {
            return "参数数据类型（如DATE/VARCHAR2/NUMBER）为空";
        }
        if (fastreportParamPojo.getDefaultValue() == null|| fastreportParamPojo.getDefaultValue().isEmpty() ) {
            return "参数默认值为空";
        }
//        if (fastreportParamPojo.getParamDesc() == null|| fastreportParamPojo.getParamDesc().isEmpty() ) {
//            return "参数描述为空";
//        }
        if (fastreportParamPojo.getIsRequired() == null|| fastreportParamPojo.getIsRequired().isEmpty() ) {
            return "是否必填（1:是 0:否）为空";
        }
        if (fastreportParamPojo.getSortNum() == null ) {
            return "参数排序号为空";
        }
        if (fastreportParamPojo.getDelFlag() == null|| fastreportParamPojo.getDelFlag().isEmpty() ) {
            return "逻辑删除标志（'0':未删除 '1':已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addFastreportParam(FastreportParamPojo fastreportParamPojo) {
    return insert(fastreportParamPojo, fastreportParamVerifyS(fastreportParamPojo, SysEnum.SAVE), fastreportParamLambdaQueryWrapper(fastreportParamPojo));
    }
    //删除
    @Override
    public Result<?> deleteFastreportParam(FastreportParamPojo fastreportParamPojo) {
    return delete(fastreportParamPojo, fastreportParamVerifyS(fastreportParamPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateFastreportParam(FastreportParamPojo fastreportParamPojo) {
    return update(fastreportParamPojo, fastreportParamVerifyS(fastreportParamPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<FastreportParamPojo>> getFastreportParamList(FastreportParamPojo fastreportParamPojo) {
        return selectFORList(fastreportParamLambdaQueryWrapper(fastreportParamPojo));
    }
    //分页查询
    @Override
    public Result<Page<FastreportParamPojo>> getFastreportParamListPage(FastreportParamPojo fastreportParamPojo) {
        return selectPage(fastreportParamPojo, fastreportParamLambdaQueryWrapper(fastreportParamPojo));
    }
}