package com.yin.module.jsyy.service.impl;

import com.yin.module.jsyy.entity.DischargeInfoPojo;
import com.yin.module.jsyy.service.IDischargeInfoService;
import com.yin.module.jsyy.mapper.DischargeInfoMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 出院信息表 服务实现类
 */
@Service
public class DischargeInfoServiceImpl extends BaseServiceImpl<DischargeInfoMapper,DischargeInfoPojo> implements IDischargeInfoService {

    /**
      常用查询条件
      * @param dischargeInfoPojo
    */
    public LambdaQueryWrapper<DischargeInfoPojo> dischargeInfoLambdaQueryWrapper(DischargeInfoPojo dischargeInfoPojo) {
        LambdaQueryWrapper<DischargeInfoPojo> dischargeInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dischargeInfoPojo.getFieldPk() != null && !dischargeInfoPojo.getFieldPk().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getFieldPk,dischargeInfoPojo.getFieldPk());
        }
        if (dischargeInfoPojo.getBaseinfoFieldPkFk() != null && !dischargeInfoPojo.getBaseinfoFieldPkFk().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getBaseinfoFieldPkFk,dischargeInfoPojo.getBaseinfoFieldPkFk());
        }
        if (dischargeInfoPojo.getZonecode() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getZonecode,dischargeInfoPojo.getZonecode());
        }
        if (dischargeInfoPojo.getOrgcode() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getOrgcode,dischargeInfoPojo.getOrgcode());
        }
        if (dischargeInfoPojo.getCardNo() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getCardNo,dischargeInfoPojo.getCardNo());
        }
        if (dischargeInfoPojo.getAttachFieldPkFk() != null && !dischargeInfoPojo.getAttachFieldPkFk().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getAttachFieldPkFk,dischargeInfoPojo.getAttachFieldPkFk());
        }
        if (dischargeInfoPojo.getInhospitalNo() != null && !dischargeInfoPojo.getInhospitalNo().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getInhospitalNo,dischargeInfoPojo.getInhospitalNo());
        }
        if (dischargeInfoPojo.getPatientName() != null && !dischargeInfoPojo.getPatientName().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getPatientName,dischargeInfoPojo.getPatientName());
        }
        if (dischargeInfoPojo.getSex() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getSex,dischargeInfoPojo.getSex());
        }
        if (dischargeInfoPojo.getDocumentType() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getDocumentType,dischargeInfoPojo.getDocumentType());
        }
        if (dischargeInfoPojo.getIdcardNum() != null && !dischargeInfoPojo.getIdcardNum().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getIdcardNum,dischargeInfoPojo.getIdcardNum());
        }
        if (dischargeInfoPojo.getNationality() != null && !dischargeInfoPojo.getNationality().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getNationality,dischargeInfoPojo.getNationality());
        }
        if (dischargeInfoPojo.getInMentalHospital() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getInMentalHospital,dischargeInfoPojo.getInMentalHospital());
        }
        if (dischargeInfoPojo.getDiagnosis() != null && !dischargeInfoPojo.getDiagnosis().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getDiagnosis,dischargeInfoPojo.getDiagnosis());
        }
        if (dischargeInfoPojo.getPastDanger() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getPastDanger,dischargeInfoPojo.getPastDanger());
        }
        if (dischargeInfoPojo.getEffect() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getEffect,dischargeInfoPojo.getEffect());
        }
        if (dischargeInfoPojo.getNextMeasures() != null) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getNextMeasures,dischargeInfoPojo.getNextMeasures());
        }
        if (dischargeInfoPojo.getNextMeasuresInst() != null && !dischargeInfoPojo.getNextMeasuresInst().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getNextMeasuresInst,dischargeInfoPojo.getNextMeasuresInst());
        }
        if (dischargeInfoPojo.getOtherInst() != null && !dischargeInfoPojo.getOtherInst().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getOtherInst,dischargeInfoPojo.getOtherInst());
        }
        if (dischargeInfoPojo.getDoctor() != null && !dischargeInfoPojo.getDoctor().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getDoctor,dischargeInfoPojo.getDoctor());
        }
        if (dischargeInfoPojo.getDoctorPhone() != null && !dischargeInfoPojo.getDoctorPhone().isEmpty()) {
            dischargeInfoLambdaQueryWrapper.eq(DischargeInfoPojo::getDoctorPhone,dischargeInfoPojo.getDoctorPhone());
        }
        return dischargeInfoLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param dischargeInfoPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String dischargeInfoVerifyS(DischargeInfoPojo dischargeInfoPojo, SysEnum type) {
        if ((dischargeInfoPojo.getFieldPk() == null || dischargeInfoPojo.getFieldPk().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "出院信息的主键 MH01.02.001 C..40 uuid为空";
        }
        if (dischargeInfoPojo.getBaseinfoFieldPkFk() == null|| dischargeInfoPojo.getBaseinfoFieldPkFk().isEmpty() ) {
            return "患者主键 MH01.02.002 C..40 uuid为空";
        }
        if (dischargeInfoPojo.getZonecode() == null ) {
            return "报告地区 MH01.02.003 N8 报告单位所属县区编码 参照附件地区机构为空";
        }
        if (dischargeInfoPojo.getOrgcode() == null ) {
            return "报告单位 MH01.02.004 N9 报告单位的组织机构编码 参照附件地区机构为空";
        }
        if (dischargeInfoPojo.getCardNo() == null ) {
            return "卡片编号（患者报告卡号） MH01.02.005 N14 按照某一特定编码规则赋予本人患者报告卡卡的顺序号为空";
        }
        if (dischargeInfoPojo.getAttachFieldPkFk() == null|| dischargeInfoPojo.getAttachFieldPkFk().isEmpty() ) {
            return "患者报告卡主键 MH01.02.006 C..40 患者报告卡主键为空";
        }
        if (dischargeInfoPojo.getInhospitalNo() == null|| dischargeInfoPojo.getInhospitalNo().isEmpty() ) {
            return "病案号—住院 MH01.02.007 C..40 患者本人住院病案号为空";
        }
        if (dischargeInfoPojo.getPatientName() == null|| dischargeInfoPojo.getPatientName().isEmpty() ) {
            return "患者姓名 MH01.02.008 C..20 患者本人在公安管理部门正式登记注册的姓氏和名称为空";
        }
        if (dischargeInfoPojo.getSex() == null ) {
            return "性别 MH01.02.009 N1 患者本人生理性别的代码 参见6.8性别为空";
        }
        if (dischargeInfoPojo.getDocumentType() == null ) {
            return "证件类型 MH01.02.011 N1 患者证件类型 参见6.6证件类型为空";
        }
        if (dischargeInfoPojo.getIdcardNum() == null|| dischargeInfoPojo.getIdcardNum().isEmpty() ) {
            return "证件号码 MH01.02.012 C..18 患者证件号码，如果有身份证号，录入身份证号为空";
        }
        if (dischargeInfoPojo.getNationality() == null|| dischargeInfoPojo.getNationality().isEmpty() ) {
            return "国籍 MH01.02.013 C4 患者国籍，患者是国外人时，为必填项。患者是中国人时，为空。为空";
        }
        if (dischargeInfoPojo.getInMentalHospital() == null ) {
            return "既往治疗情况—曾住精神专科医院次数 MH01.02.016 N..4 患者本人曾住精神专科医院次数为空";
        }
        if (dischargeInfoPojo.getDiagnosis() == null|| dischargeInfoPojo.getDiagnosis().isEmpty() ) {
            return "出院诊断 MH01.02.017 C..20 患者本人出院时的精神疾病诊断类型的代码 参见6.12ICD10编码为空";
        }
        if (dischargeInfoPojo.getPastDanger() == null ) {
            return "既往危险行为 MH01.02.019 N1 患者的既往危险行为情况，必填项；可多选；如选择无上述危险行为或风险，其他选项不可选择，码值用分隔 参见6.26既往危险行为为空";
        }
        if (dischargeInfoPojo.getEffect() == null ) {
            return "住院疗效 MH01.02.020 N1 患者本次住院的治疗效果代码 参见6.23治疗效果为空";
        }
        if (dischargeInfoPojo.getNextMeasures() == null ) {
            return "康复措施 MH01.02.021 N1 患者本人出院后的康复措施代码 参见 6.31 康复措施为空";
        }
        if (dischargeInfoPojo.getNextMeasuresInst() == null|| dischargeInfoPojo.getNextMeasuresInst().isEmpty() ) {
            return "康复措施其他请注明 MH01.02.022 C..80 康复措施选其他后的注明为空";
        }
        if (dischargeInfoPojo.getOtherInst() == null|| dischargeInfoPojo.getOtherInst().isEmpty() ) {
            return "其他注意事项 MH01.02.023 C..80 患者本人下一步治疗方案的其他注意事项为空";
        }
        if (dischargeInfoPojo.getDoctor() == null|| dischargeInfoPojo.getDoctor().isEmpty() ) {
            return "经治医生 MH01.02.024 C..20 患者本人治疗医师的姓名为空";
        }
        if (dischargeInfoPojo.getDoctorPhone() == null|| dischargeInfoPojo.getDoctorPhone().isEmpty() ) {
            return "联系电话 MH01.02.025 C..13 经治医生的联系电话为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addDischargeInfo(DischargeInfoPojo dischargeInfoPojo) {
    return insert(dischargeInfoPojo, dischargeInfoVerifyS(dischargeInfoPojo, SysEnum.SAVE), dischargeInfoLambdaQueryWrapper(dischargeInfoPojo));
    }
    //删除
    @Override
    public Result<?> deleteDischargeInfo(DischargeInfoPojo dischargeInfoPojo) {
    return delete(dischargeInfoPojo, dischargeInfoVerifyS(dischargeInfoPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateDischargeInfo(DischargeInfoPojo dischargeInfoPojo) {
    return update(dischargeInfoPojo, dischargeInfoVerifyS(dischargeInfoPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<DischargeInfoPojo>> getDischargeInfoList(DischargeInfoPojo dischargeInfoPojo) {
        return selectFORList(dischargeInfoLambdaQueryWrapper(dischargeInfoPojo));
    }
    //分页查询
    @Override
    public Result<Page<DischargeInfoPojo>> getDischargeInfoListPage(DischargeInfoPojo dischargeInfoPojo) {
        return selectPage(dischargeInfoPojo, dischargeInfoLambdaQueryWrapper(dischargeInfoPojo));
    }
}