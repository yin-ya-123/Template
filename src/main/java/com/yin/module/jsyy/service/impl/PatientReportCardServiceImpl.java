package com.yin.module.jsyy.service.impl;

import com.yin.base.utils.UUIDUtil;
import com.yin.module.jsyy.entity.PatientReportCardPojo;
import com.yin.module.jsyy.service.IPatientReportCardService;
import com.yin.module.jsyy.mapper.PatientReportCardMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 患者报告卡主表 服务实现类
 */
@Service
public class PatientReportCardServiceImpl extends BaseServiceImpl<PatientReportCardMapper, PatientReportCardPojo> implements IPatientReportCardService {

    /**
     * 常用查询条件
     *
     * @param patientReportCardPojo
     */
    public LambdaQueryWrapper<PatientReportCardPojo> patientReportCardLambdaQueryWrapper(PatientReportCardPojo patientReportCardPojo) {
        LambdaQueryWrapper<PatientReportCardPojo> patientReportCardLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        if (patientReportCardPojo.getFieldPk() != null && !patientReportCardPojo.getFieldPk().isEmpty()) {
//            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getFieldPk, patientReportCardPojo.getFieldPk());
//        }
//        if (patientReportCardPojo.getBaseinfoFieldPkFk() != null && !patientReportCardPojo.getBaseinfoFieldPkFk().isEmpty()) {
//            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getBaseinfoFieldPkFk, patientReportCardPojo.getBaseinfoFieldPkFk());
//        }
        if (patientReportCardPojo.getZonecode() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getZonecode, patientReportCardPojo.getZonecode());
        }
        if (patientReportCardPojo.getOrgcode() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getOrgcode, patientReportCardPojo.getOrgcode());
        }
        if (patientReportCardPojo.getCardNo() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getCardNo, patientReportCardPojo.getCardNo());
        }
        if (patientReportCardPojo.getDivision() != null && !patientReportCardPojo.getDivision().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getDivision, patientReportCardPojo.getDivision());
        }
        if (patientReportCardPojo.getClinNo() != null && !patientReportCardPojo.getClinNo().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getClinNo, patientReportCardPojo.getClinNo());
        }
        if (patientReportCardPojo.getInhosNo() != null && !patientReportCardPojo.getInhosNo().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getInhosNo, patientReportCardPojo.getInhosNo());
        }
        if (patientReportCardPojo.getPatientName() != null && !patientReportCardPojo.getPatientName().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getPatientName, patientReportCardPojo.getPatientName());
        }
        if (patientReportCardPojo.getSex() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getSex, patientReportCardPojo.getSex());
        }
        if (patientReportCardPojo.getDocumentType() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getDocumentType, patientReportCardPojo.getDocumentType());
        }
        if (patientReportCardPojo.getIdcardNum() != null && !patientReportCardPojo.getIdcardNum().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getIdcardNum, patientReportCardPojo.getIdcardNum());
        }
        if (patientReportCardPojo.getNationality() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getNationality, patientReportCardPojo.getNationality());
        }
        if (patientReportCardPojo.getNation() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getNation, patientReportCardPojo.getNation());
        }
        if (patientReportCardPojo.getRegistertype() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getRegistertype, patientReportCardPojo.getRegistertype());
        }
        if (patientReportCardPojo.getContactName() != null && !patientReportCardPojo.getContactName().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getContactName, patientReportCardPojo.getContactName());
        }
        if (patientReportCardPojo.getContactPhone() != null && !patientReportCardPojo.getContactPhone().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getContactPhone, patientReportCardPojo.getContactPhone());
        }
        if (patientReportCardPojo.getRelationship() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getRelationship, patientReportCardPojo.getRelationship());
        }
        if (patientReportCardPojo.getRegisteraddr() != null && !patientReportCardPojo.getRegisteraddr().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getRegisteraddr, patientReportCardPojo.getRegisteraddr());
        }
        if (patientReportCardPojo.getAreatype() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getAreatype, patientReportCardPojo.getAreatype());
        }
        if (patientReportCardPojo.getRegisterzonecode() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getRegisterzonecode, patientReportCardPojo.getRegisterzonecode());
        }
        if (patientReportCardPojo.getAddr() != null && !patientReportCardPojo.getAddr().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getAddr, patientReportCardPojo.getAddr());
        }
        if (patientReportCardPojo.getAddrcode() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getAddrcode, patientReportCardPojo.getAddrcode());
        }
        if (patientReportCardPojo.getEducationback() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getEducationback, patientReportCardPojo.getEducationback());
        }
        if (patientReportCardPojo.getMarriage() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getMarriage, patientReportCardPojo.getMarriage());
        }
        if (patientReportCardPojo.getEmployment() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getEmployment, patientReportCardPojo.getEmployment());
        }
        if (patientReportCardPojo.getFamilyHistory() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getFamilyHistory, patientReportCardPojo.getFamilyHistory());
        }
        if (patientReportCardPojo.getFirstIllTimeAccuracy() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getFirstIllTimeAccuracy, patientReportCardPojo.getFirstIllTimeAccuracy());
        }
        if (patientReportCardPojo.getIfCure() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getIfCure, patientReportCardPojo.getIfCure());
        }
        if (patientReportCardPojo.getFirstCureTimeAccuracy() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getFirstCureTimeAccuracy, patientReportCardPojo.getFirstCureTimeAccuracy());
        }
        if (patientReportCardPojo.getHospitalStateHistory() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getHospitalStateHistory, patientReportCardPojo.getHospitalStateHistory());
        }
        if (patientReportCardPojo.getShutStatusHistory() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getShutStatusHistory, patientReportCardPojo.getShutStatusHistory());
        }
//        if (patientReportCardPojo.getPastDanger() != null) {
//            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getPastDanger, patientReportCardPojo.getPastDanger());
//        }
        if (patientReportCardPojo.getRiskPast() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getRiskPast, patientReportCardPojo.getRiskPast());
        }
        if (patientReportCardPojo.getSendDiagnosis() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getSendDiagnosis, patientReportCardPojo.getSendDiagnosis());
        }
        if (patientReportCardPojo.getSendDiagnosisOther() != null && !patientReportCardPojo.getSendDiagnosisOther().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getSendDiagnosisOther, patientReportCardPojo.getSendDiagnosisOther());
        }
        if (patientReportCardPojo.getDiagnosisHospital() != null && !patientReportCardPojo.getDiagnosisHospital().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getDiagnosisHospital, patientReportCardPojo.getDiagnosisHospital());
        }
        if (patientReportCardPojo.getIcd10Code() != null && !patientReportCardPojo.getIcd10Code().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getIcd10Code, patientReportCardPojo.getIcd10Code());
        }
        if (patientReportCardPojo.getInformed() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getInformed, patientReportCardPojo.getInformed());
        }
        if (patientReportCardPojo.getFillDoctor() != null && !patientReportCardPojo.getFillDoctor().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getFillDoctor, patientReportCardPojo.getFillDoctor());
        }
        if (patientReportCardPojo.getDepartment() != null && !patientReportCardPojo.getDepartment().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getDepartment, patientReportCardPojo.getDepartment());
        }
        if (patientReportCardPojo.getDepartmentPhone() != null && !patientReportCardPojo.getDepartmentPhone().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getDepartmentPhone, patientReportCardPojo.getDepartmentPhone());
        }
        if (patientReportCardPojo.getReportType() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getReportType, patientReportCardPojo.getReportType());
        }
        if (patientReportCardPojo.getInfocreater() != null && !patientReportCardPojo.getInfocreater().isEmpty()) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getInfocreater, patientReportCardPojo.getInfocreater());
        }
        if (patientReportCardPojo.getIfNomedication() != null) {
            patientReportCardLambdaQueryWrapper.eq(PatientReportCardPojo::getIfNomedication, patientReportCardPojo.getIfNomedication());
        }
        return patientReportCardLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param patientReportCardPojo 实体
     * @param type                  操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String patientReportCardVerifyS(PatientReportCardPojo patientReportCardPojo, SysEnum type) {
        if ((patientReportCardPojo.getFieldPk() == null || patientReportCardPojo.getFieldPk().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "患者报告卡的主键 MH01.01.001 C..40 uuid为空";
        }
        if (patientReportCardPojo.getBaseinfoFieldPkFk() == null || patientReportCardPojo.getBaseinfoFieldPkFk().isEmpty()) {
            return "患者主键 MH01.01.002 C..40 uuid为空";
        }
        if (patientReportCardPojo.getZonecode() == null) {
            return "报告地区 MH01.01.003 N9 报告单位所属县区编码 参见附件地区为空";
        }
        if (patientReportCardPojo.getOrgcode() == null) {
            return "报告单位（医院名称） MH01.01.004 N9 报告单位的组织机构编码 参见附件机构为空";
        }
        if (patientReportCardPojo.getCardNo() == null) {
            return "卡片编号(患者报告卡号) MH01.01.005 N14 按照某一特定编码规则赋予本人患者报告卡卡的顺序号，也叫卡片编号为空";
        }
        if (patientReportCardPojo.getDivision() == null || patientReportCardPojo.getDivision().isEmpty()) {
            return "患者来源(报告部门) MH01.01.006 C..4 必填项，报告部门（患者来源） 1门诊部2住院部 参见6.5报告部门为空";
        }
//        if (patientReportCardPojo.getClinNo() == null || patientReportCardPojo.getClinNo().isEmpty()) {
//            return "门诊编号 MH01.01.007 C..30 DIVISION 选择门诊部时必填为空";
//        }
//        if (patientReportCardPojo.getInhosNo() == null || patientReportCardPojo.getInhosNo().isEmpty()) {
//            return "住院编号 MH01.01.008 c..30 DIVISION 选择住院部时必填为空";
//        }
        if (patientReportCardPojo.getPatientName() == null || patientReportCardPojo.getPatientName().isEmpty()) {
            return "患者姓名 MH01.01.009 C..20 患者本人在公安管理部门正式登记注册的姓氏和名称为空";
        }
        if (patientReportCardPojo.getSex() == null) {
            return "性别 MH01.01.010 N1 患者本人生理性别的代码 参见6.8gender性别为空";
        }
        if (patientReportCardPojo.getDocumentType() == null) {
            return "证件类型 MH01.01.012 N1 患者证件类型 参见 6.6 证件类型 documenttype为空";
        }
        if (patientReportCardPojo.getIdcardNum() == null || patientReportCardPojo.getIdcardNum().isEmpty()) {
            return "证件号码 MH01.01.013 C..18 患者证件号码，如果有身份证号，录入身份证号为空";
        }
//        if (patientReportCardPojo.getNationality() == null) {
//            return "国籍 MH01.01.014 N1 患者国籍，患者是国外人时，为必填项。患者是中国人时，为空。 参见附件国籍为空";
//        }
        if (patientReportCardPojo.getNation() == null) {
            return "民族 MH01.01.015 N2 必填项 参见6.19民族为空";
        }
        if (patientReportCardPojo.getRegistertype() == null) {
            return "户别 MH01.01.016 N1 必填项，单选 参见6.42户别为空";
        }
        if (patientReportCardPojo.getContactName() == null || patientReportCardPojo.getContactName().isEmpty()) {
            return "联系人姓名 MH01.01.017 C..20 患者家属在公安管理部门正式登记注册的姓氏和名称为空";
        }
        if (patientReportCardPojo.getContactPhone() == null || patientReportCardPojo.getContactPhone().isEmpty()) {
            return "联系人电话 MH01.01.018 C..20 联系人的电话号码为空";
        }
        if (patientReportCardPojo.getRelationship() == null) {
            return "与监护人关系 MH01.01.019 N1 必填项 参见6.24人员关系表为空";
        }
        if (patientReportCardPojo.getRegisteraddr() == null || patientReportCardPojo.getRegisteraddr().isEmpty()) {
            return "户籍地 MH01.01.020 C...200 患者本人户籍地详细地址为空";
        }
        if (patientReportCardPojo.getAreatype() == null) {
            return "户籍地址类型 MH01.01.021 N1 患者本人户籍地址类型对应代码 参见6.2地区类型为空";
        }
        if (patientReportCardPojo.getRegisterzonecode() == null) {
            return "户籍国标码 MH01.01.022 N9 患者本人户籍地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处对应的国标编码 参见附件户籍用地区为空";
        }
        if (patientReportCardPojo.getAddr() == null || patientReportCardPojo.getAddr().isEmpty()) {
            return "现住址 MH01.01.023 C..200 患者本人现住地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处名称和门牌号为空";
        }
        if (patientReportCardPojo.getAddrcode() == null) {
            return "现住地国标码 MH01.01.024 N9 患者本人现住地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处对应的国标码 参见附件户籍用地区为空";
        }
        if (patientReportCardPojo.getEducationback() == null) {
            return "文化程度 MH01.01.025 N4 必填项，单选 参见6.7文化程度为空";
        }
        if (patientReportCardPojo.getMarriage() == null) {
            return "婚姻状况 MH01.01.026 N4 必填项 参见6.18婚姻状况为空";
        }
        if (patientReportCardPojo.getEmployment() == null) {
            return "就业情况 MH01.01.027 N4 必填项 参见6.17职业为空";
        }
        if (patientReportCardPojo.getFamilyHistory() == null) {
            return "两系三代精神疾病家族史 MH01.01.028 N4 两系三代精神疾病家族史 参见6.10 有无不详为空";
        }
        if (patientReportCardPojo.getFirstIllTimeAccuracy() == null) {
            return "初次发病时间精确度 MH01.01.030 N1 患者本人首次出现精神症状时间的精确程度 参见6.22时间精确度为空";
        }
        if (patientReportCardPojo.getIfCure() == null) {
            return "是否已进行抗精神病药物治疗 MH01.01.031 N2 必填项 参见6.16是否为空";
        }
        if (patientReportCardPojo.getFirstCureTimeAccuracy() == null) {
            return "首次抗精神病药治疗时间精确度 MH01.01.033 N1 患者本人首次抗精神病药治疗当日公元纪年日期的精确程度 参见6.22时间精确度为空";
        }
        if (patientReportCardPojo.getHospitalStateHistory() == null) {
            return "既往住院情况 MH01.01.034 N2 必填项，只可录入整数，单位为次为空";
        }
        if (patientReportCardPojo.getShutStatusHistory() == null) {
            return "既往关锁情况 MH01.01.035 N2 必填项，只可单选 参见6.25关锁情况为空";
        }
        if (patientReportCardPojo.getPastDanger() == null) {
            return "既往危险行为 MH01.01.036 N1 患者的既往危险行为情况，必填项；可多选；如选择无上述危险行为或风险，其他选项不可选择，码值用分隔 参见6.26既往危险行为为空";
        }
        if (patientReportCardPojo.getRiskPast() == null) {
            return "既往危险性评估 MH01.01.037 N2 必填项 参见6.21危险行为级别为空";
        }
        if (patientReportCardPojo.getSendDiagnosis() == null) {
            return "送诊主体 MH01.01.038 N..2 送患者去就诊的主体代码 参见6.60 送诊主体为空";
        }
        if (patientReportCardPojo.getSendDiagnosisOther() == null || patientReportCardPojo.getSendDiagnosisOther().isEmpty()) {
            return "送诊主体—其他 MH01.01.039 C..80 送诊主体为其他时，的具体信息为空";
        }
        if (patientReportCardPojo.getDiagnosisHospital() == null || patientReportCardPojo.getDiagnosisHospital().isEmpty()) {
            return "确诊医院 MH01.01.040 C..40 患者本人就诊的医院名称为空";
        }
        if (patientReportCardPojo.getIcd10Code() == null || patientReportCardPojo.getIcd10Code().isEmpty()) {
            return "疾病名称及ICD10编码 MH01.01.042 C..20 患者本人的精神疾病诊断类型的代码 参见 6.12ICD10编码为空";
        }
        if (patientReportCardPojo.getInformed() == null) {
            return "知情同意 MH01.01.043 N1 必填项，如果当前报告卡类型为发病报告患者：符合精神卫生法第三十条第二款第二项情形，此字段默认值为同意。 参见 6.1知情同意书为空";
        }
        if (patientReportCardPojo.getFillDoctor() == null || patientReportCardPojo.getFillDoctor().isEmpty()) {
            return "填卡医生 MH01.01.045 C..20 填写本患者报告卡卡的医师在公安管理部门正式登记注册的姓氏和名称为空";
        }
        if (patientReportCardPojo.getDepartment() == null || patientReportCardPojo.getDepartment().isEmpty()) {
            return "报告单位及科室 MH01.01.047 C..40 填卡医生所属医院的科室名称为空";
        }
        if (patientReportCardPojo.getDepartmentPhone() == null || patientReportCardPojo.getDepartmentPhone().isEmpty()) {
            return "科室联系电话 MH01.01.048 C..13 报告科室的联系电话为空";
        }
        if (patientReportCardPojo.getReportType() == null) {
            return "报告类型 MH01.01.049 N1 1 发病报告患者：符合精神卫生法第三十条第二款第二项情形 2 按要求登记的六类病种为空";
        }
        if (patientReportCardPojo.getInfocreater() == null || patientReportCardPojo.getInfocreater().isEmpty()) {
            return "信息创建人 MH01.01.050 C..20 信息创建者为空";
        }
        if (patientReportCardPojo.getIfNomedication() == null) {
            return "勿需用药 MH01.01.052 N1 当选是时，不可填写目前用药情况；当选否时必填目前用药情况。 参见6.16 是否为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addPatientReportCard(PatientReportCardPojo patientReportCardPojo) {
        System.out.println(patientReportCardPojo.toString());
//        设置UUID
        String uuid = UUIDUtil.getUUID(40);
        patientReportCardPojo.setFieldPk(uuid);
        patientReportCardPojo.setBaseinfoFieldPkFk(uuid);
        return insert(patientReportCardPojo, patientReportCardVerifyS(patientReportCardPojo, SysEnum.SAVE), patientReportCardLambdaQueryWrapper(patientReportCardPojo));
    }

    //删除
    @Override
    public Result<?> deletePatientReportCard(PatientReportCardPojo patientReportCardPojo) {
        return delete(patientReportCardPojo, patientReportCardVerifyS(patientReportCardPojo, SysEnum.DELETE));
    }

    //修改
    @Override
    public Result<?> updatePatientReportCard(PatientReportCardPojo patientReportCardPojo) {
        return update(patientReportCardPojo, patientReportCardVerifyS(patientReportCardPojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<PatientReportCardPojo>> getPatientReportCardList(PatientReportCardPojo patientReportCardPojo) {
        return selectFORList(patientReportCardLambdaQueryWrapper(patientReportCardPojo));
    }

    //分页查询
    @Override
    public Result<Page<PatientReportCardPojo>> getPatientReportCardListPage(PatientReportCardPojo patientReportCardPojo) {
        return selectPage(patientReportCardPojo, patientReportCardLambdaQueryWrapper(patientReportCardPojo));
    }
}