package com.yin.module.jsyy.service.impl;

import com.yin.module.jsyy.entity.DischargeDrugPojo;
import com.yin.module.jsyy.service.IDischargeDrugService;
import com.yin.module.jsyy.mapper.DischargeDrugMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 出院信息附属药物表 服务实现类
 */
@Service
public class DischargeDrugServiceImpl extends BaseServiceImpl<DischargeDrugMapper,DischargeDrugPojo> implements IDischargeDrugService {

    /**
      常用查询条件
      * @param dischargeDrugPojo
    */
    public LambdaQueryWrapper<DischargeDrugPojo> dischargeDrugLambdaQueryWrapper(DischargeDrugPojo dischargeDrugPojo) {
        LambdaQueryWrapper<DischargeDrugPojo> dischargeDrugLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dischargeDrugPojo.getFieldPkFk() != null && !dischargeDrugPojo.getFieldPkFk().isEmpty()) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getFieldPkFk,dischargeDrugPojo.getFieldPkFk());
        }
        if (dischargeDrugPojo.getType() != null && !dischargeDrugPojo.getType().isEmpty()) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getType,dischargeDrugPojo.getType());
        }
        if (dischargeDrugPojo.getNum() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getNum,dischargeDrugPojo.getNum());
        }
        if (dischargeDrugPojo.getIflongdrug() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getIflongdrug,dischargeDrugPojo.getIflongdrug());
        }
        if (dischargeDrugPojo.getDrug() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrug,dischargeDrugPojo.getDrug());
        }
        if (dischargeDrugPojo.getDrugcode() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugcode,dischargeDrugPojo.getDrugcode());
        }
        if (dischargeDrugPojo.getDrugcompany() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugcompany,dischargeDrugPojo.getDrugcompany());
        }
        if (dischargeDrugPojo.getDrugother() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugother,dischargeDrugPojo.getDrugother());
        }
        if (dischargeDrugPojo.getDruguse() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDruguse,dischargeDrugPojo.getDruguse());
        }
        if (dischargeDrugPojo.getDruguse1() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDruguse1,dischargeDrugPojo.getDruguse1());
        }
        if (dischargeDrugPojo.getDruguse2() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDruguse2,dischargeDrugPojo.getDruguse2());
        }
        if (dischargeDrugPojo.getDrugfrequency() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugfrequency,dischargeDrugPojo.getDrugfrequency());
        }
        if (dischargeDrugPojo.getDrugdose() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugdose,dischargeDrugPojo.getDrugdose());
        }
        if (dischargeDrugPojo.getDrugtime() != null) {
            dischargeDrugLambdaQueryWrapper.eq(DischargeDrugPojo::getDrugtime,dischargeDrugPojo.getDrugtime());
        }
        return dischargeDrugLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param dischargeDrugPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String dischargeDrugVerifyS(DischargeDrugPojo dischargeDrugPojo, SysEnum type) {
        if (dischargeDrugPojo.getFieldPkFk() == null|| dischargeDrugPojo.getFieldPkFk().isEmpty() ) {
            return "出院信息主键 FK C..40 关联出院信息表的外键为空";
        }
        if (dischargeDrugPojo.getType() == null|| dischargeDrugPojo.getType().isEmpty() ) {
            return "类型 MH01.02.027 C..4 类型01住院用药02用药指导为空";
        }
        if (dischargeDrugPojo.getNum() == null ) {
            return "序号 MH01.01.053 N1 药物顺序号，从1开始，递增为空";
        }
        if (dischargeDrugPojo.getIflongdrug() == null ) {
            return "目前用药情况-是否长效 MH01.01.054 N1 目前用药情况-是否长效 参见6.28 是否长效药为空";
        }
        if (dischargeDrugPojo.getDrug() == null ) {
            return "药品名称 MH01.01.055 N20 药品通用名称 查看药品附件为空";
        }
        if (dischargeDrugPojo.getDrugcode() == null ) {
            return "药品编码 MH01.01.056 N20 药品编码 查看药品附件为空";
        }
        if (dischargeDrugPojo.getDrugcompany() == null ) {
            return "单位 MH01.01.057 N5  查看药品附件为空";
        }
        if (dischargeDrugPojo.getDrugother() == null ) {
            return "规格 MH01.01.058 N8  查看药品附件为空";
        }
        if (dischargeDrugPojo.getDruguse() == null ) {
            return "早 MH01.01.059 N4 选择非长效药时传为空";
        }
        if (dischargeDrugPojo.getDruguse1() == null ) {
            return "中 MH01.01.060 N4 选择非长效药时传为空";
        }
        if (dischargeDrugPojo.getDruguse2() == null ) {
            return "晚 MH01.01.061 N4 选择非长效药时传为空";
        }
        if (dischargeDrugPojo.getDrugfrequency() == null ) {
            return "频次 MH01.01.062 N2 选择长效药时传为空";
        }
        if (dischargeDrugPojo.getDrugdose() == null ) {
            return "计量 MH01.01.063 N3 选择长效药时传为空";
        }
        if (dischargeDrugPojo.getDrugtime() == null ) {
            return "频率 MH01.01.064 N2 选择长效药时传 参见6.29 用药周期为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addDischargeDrug(DischargeDrugPojo dischargeDrugPojo) {
    return insert(dischargeDrugPojo, dischargeDrugVerifyS(dischargeDrugPojo, SysEnum.SAVE), dischargeDrugLambdaQueryWrapper(dischargeDrugPojo));
    }
    //删除
    @Override
    public Result<?> deleteDischargeDrug(DischargeDrugPojo dischargeDrugPojo) {
    return delete(dischargeDrugPojo, dischargeDrugVerifyS(dischargeDrugPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateDischargeDrug(DischargeDrugPojo dischargeDrugPojo) {
    return update(dischargeDrugPojo, dischargeDrugVerifyS(dischargeDrugPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<DischargeDrugPojo>> getDischargeDrugList(DischargeDrugPojo dischargeDrugPojo) {
        return selectFORList(dischargeDrugLambdaQueryWrapper(dischargeDrugPojo));
    }
    //分页查询
    @Override
    public Result<Page<DischargeDrugPojo>> getDischargeDrugListPage(DischargeDrugPojo dischargeDrugPojo) {
        return selectPage(dischargeDrugPojo, dischargeDrugLambdaQueryWrapper(dischargeDrugPojo));
    }
}