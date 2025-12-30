package com.yin.module.jsyy.service.impl;

import com.yin.module.jsyy.entity.PatientReportDrugPojo;
import com.yin.module.jsyy.service.IPatientReportDrugService;
import com.yin.module.jsyy.mapper.PatientReportDrugMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 报告卡附属药物表 服务实现类
 */
@Service
public class PatientReportDrugServiceImpl extends BaseServiceImpl<PatientReportDrugMapper,PatientReportDrugPojo> implements IPatientReportDrugService {

    /**
      常用查询条件
      * @param patientReportDrugPojo
    */
    public LambdaQueryWrapper<PatientReportDrugPojo> patientReportDrugLambdaQueryWrapper(PatientReportDrugPojo patientReportDrugPojo) {
        LambdaQueryWrapper<PatientReportDrugPojo> patientReportDrugLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (patientReportDrugPojo.getFieldPkFk() != null && !patientReportDrugPojo.getFieldPkFk().isEmpty()) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getFieldPkFk,patientReportDrugPojo.getFieldPkFk());
        }
        if (patientReportDrugPojo.getNum() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getNum,patientReportDrugPojo.getNum());
        }
        if (patientReportDrugPojo.getIflongdrug() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getIflongdrug,patientReportDrugPojo.getIflongdrug());
        }
        if (patientReportDrugPojo.getDrug() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrug,patientReportDrugPojo.getDrug());
        }
        if (patientReportDrugPojo.getDrugcode() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugcode,patientReportDrugPojo.getDrugcode());
        }
        if (patientReportDrugPojo.getDrugcompany() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugcompany,patientReportDrugPojo.getDrugcompany());
        }
        if (patientReportDrugPojo.getDrugother() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugother,patientReportDrugPojo.getDrugother());
        }
        if (patientReportDrugPojo.getDruguse() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDruguse,patientReportDrugPojo.getDruguse());
        }
        if (patientReportDrugPojo.getDruguse1() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDruguse1,patientReportDrugPojo.getDruguse1());
        }
        if (patientReportDrugPojo.getDruguse2() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDruguse2,patientReportDrugPojo.getDruguse2());
        }
        if (patientReportDrugPojo.getDrugfrequency() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugfrequency,patientReportDrugPojo.getDrugfrequency());
        }
        if (patientReportDrugPojo.getDrugdose() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugdose,patientReportDrugPojo.getDrugdose());
        }
        if (patientReportDrugPojo.getDrugtime() != null) {
            patientReportDrugLambdaQueryWrapper.eq(PatientReportDrugPojo::getDrugtime,patientReportDrugPojo.getDrugtime());
        }
        return patientReportDrugLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param patientReportDrugPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String patientReportDrugVerifyS(PatientReportDrugPojo patientReportDrugPojo, SysEnum type) {
        if (patientReportDrugPojo.getFieldPkFk() == null|| patientReportDrugPojo.getFieldPkFk().isEmpty() ) {
            return "患者报告卡主键 FK C..40 关联患者报告卡主表的外键为空";
        }
        if (patientReportDrugPojo.getNum() == null ) {
            return "序号 MH01.01.053 N1 药物顺序号，从1开始，递增为空";
        }
        if (patientReportDrugPojo.getIflongdrug() == null ) {
            return "目前用药情况-是否长效 MH01.01.054 N1 目前用药情况-是否长效 参见6.28 是否长效药为空";
        }
        if (patientReportDrugPojo.getDrug() == null ) {
            return "药品名称 MH01.01.055 N20 药品通用名称 查看药品附件为空";
        }
        if (patientReportDrugPojo.getDrugcode() == null ) {
            return "药品编码 MH01.01.056 N20 药品编码 查看药品附件为空";
        }
        if (patientReportDrugPojo.getDrugcompany() == null ) {
            return "单位 MH01.01.057 N5  查看药品附件为空";
        }
        if (patientReportDrugPojo.getDrugother() == null ) {
            return "规格 MH01.01.058 N8  查看药品附件为空";
        }
        if (patientReportDrugPojo.getDruguse() == null ) {
            return "早 MH01.01.059 N4 选择非长效药时传为空";
        }
        if (patientReportDrugPojo.getDruguse1() == null ) {
            return "中 MH01.01.060 N4 选择非长效药时传为空";
        }
        if (patientReportDrugPojo.getDruguse2() == null ) {
            return "晚 MH01.01.061 N4 选择非长效药时传为空";
        }
        if (patientReportDrugPojo.getDrugfrequency() == null ) {
            return "频次 MH01.01.062 N2 选择长效药时传为空";
        }
        if (patientReportDrugPojo.getDrugdose() == null ) {
            return "计量 MH01.01.063 N3 选择长效药时传为空";
        }
        if (patientReportDrugPojo.getDrugtime() == null ) {
            return "频率 MH01.01.064 N2 选择长效药时传 参见6.29 用药周期为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addPatientReportDrug(PatientReportDrugPojo patientReportDrugPojo) {
    return insert(patientReportDrugPojo, patientReportDrugVerifyS(patientReportDrugPojo, SysEnum.SAVE), patientReportDrugLambdaQueryWrapper(patientReportDrugPojo));
    }
    //删除
    @Override
    public Result<?> deletePatientReportDrug(PatientReportDrugPojo patientReportDrugPojo) {
    return delete(patientReportDrugPojo, patientReportDrugVerifyS(patientReportDrugPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updatePatientReportDrug(PatientReportDrugPojo patientReportDrugPojo) {
    return update(patientReportDrugPojo, patientReportDrugVerifyS(patientReportDrugPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<PatientReportDrugPojo>> getPatientReportDrugList(PatientReportDrugPojo patientReportDrugPojo) {
        return selectFORList(patientReportDrugLambdaQueryWrapper(patientReportDrugPojo));
    }
    //分页查询
    @Override
    public Result<Page<PatientReportDrugPojo>> getPatientReportDrugListPage(PatientReportDrugPojo patientReportDrugPojo) {
        return selectPage(patientReportDrugPojo, patientReportDrugLambdaQueryWrapper(patientReportDrugPojo));
    }
}