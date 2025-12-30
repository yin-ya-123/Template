package com.yin.module.jsyy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 患者报告卡主表
 */
@Data
@TableName("PATIENT_REPORT_CARD")
public class PatientReportCardPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 患者报告卡的主键 MH01.01.001 C..40 uuid
     */
    @TableId("FIELD_PK")
    @JsonProperty
    private String fieldPk;

    /**
     * 患者主键 MH01.01.002 C..40 uuid
     */
    @TableField("BASEINFO_FIELD_PK_FK")
    @JsonProperty
    private String baseinfoFieldPkFk;

    /**
     * 报告地区 MH01.01.003 N9 报告单位所属县区编码 参见附件地区
     */
    @TableField("ZONECODE")
    @JsonProperty
    private Integer zonecode;

    /**
     * 报告单位（医院名称） MH01.01.004 N9 报告单位的组织机构编码 参见附件机构
     */
    @TableField("ORGCODE")
    @JsonProperty
    private Integer orgcode;

    /**
     * 卡片编号(患者报告卡号) MH01.01.005 N14 按照某一特定编码规则赋予本人患者报告卡卡的顺序号，也叫卡片编号
     */
    @TableField("CARD_NO")
    @JsonProperty
    private Long cardNo;

    /**
     * 患者来源(报告部门) MH01.01.006 C..4 必填项，报告部门（患者来源） 1门诊部2住院部 参见6.5报告部门
     */
    @TableField("DIVISION")
    @JsonProperty
    private String division;

    /**
     * 门诊编号 MH01.01.007 C..30 DIVISION 选择门诊部时必填
     */
    @TableField("CLIN_NO")
    @JsonProperty
    private String clinNo;

    /**
     * 住院编号 MH01.01.008 c..30 DIVISION 选择住院部时必填
     */
    @TableField("INHOS_NO")
    @JsonProperty
    private String inhosNo;

    /**
     * 患者姓名 MH01.01.009 C..20 患者本人在公安管理部门正式登记注册的姓氏和名称
     */
    @TableField("PATIENT_NAME")
    @JsonProperty
    private String patientName;

    /**
     * 性别 MH01.01.010 N1 患者本人生理性别的代码 参见6.8gender性别
     */
    @TableField("SEX")
    @JsonProperty
    private Integer sex;

    /**
     * 出生日期 MH01.01.011 D8 患者本人出生当日的公元纪年日期
     */
    @TableField("BIRTHDAY_DATE")
    @JsonProperty
    private LocalDateTime birthdayDate;

    /**
     * 证件类型 MH01.01.012 N1 患者证件类型 参见 6.6 证件类型 documenttype
     */
    @TableField("DOCUMENT_TYPE")
    @JsonProperty
    private Integer documentType;

    /**
     * 证件号码 MH01.01.013 C..18 患者证件号码，如果有身份证号，录入身份证号
     */
    @TableField("IDCARD_NUM")
    @JsonProperty
    private String idcardNum;

    /**
     * 国籍 MH01.01.014 N1 患者国籍，患者是国外人时，为必填项。患者是中国人时，为空。 参见附件国籍
     */
    @TableField("NATIONALITY")
    @JsonProperty
    private Integer nationality;

    /**
     * 民族 MH01.01.015 N2 必填项 参见6.19民族
     */
    @TableField("NATION")
    @JsonProperty
    private Integer nation;

    /**
     * 户别 MH01.01.016 N1 必填项，单选 参见6.42户别
     */
    @TableField("REGISTERTYPE")
    @JsonProperty
    private Integer registertype;

    /**
     * 联系人姓名 MH01.01.017 C..20 患者家属在公安管理部门正式登记注册的姓氏和名称
     */
    @TableField("CONTACT_NAME")
    @JsonProperty
    private String contactName;

    /**
     * 联系人电话 MH01.01.018 C..20 联系人的电话号码
     */
    @TableField("CONTACT_PHONE")
    @JsonProperty
    private String contactPhone;

    /**
     * 与监护人关系 MH01.01.019 N1 必填项 参见6.24人员关系表
     */
    @TableField("RELATIONSHIP")
    @JsonProperty
    private Integer relationship;

    /**
     * 户籍地 MH01.01.020 C...200 患者本人户籍地详细地址
     */
    @TableField("REGISTERADDR")
    @JsonProperty
    private String registeraddr;

    /**
     * 户籍地址类型 MH01.01.021 N1 患者本人户籍地址类型对应代码 参见6.2地区类型
     */
    @TableField("AREATYPE")
    @JsonProperty
    private Integer areatype;

    /**
     * 户籍国标码 MH01.01.022 N9 患者本人户籍地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处对应的国标编码 参见附件户籍用地区
     */
    @TableField("REGISTERZONECODE")
    @JsonProperty
    private Integer registerzonecode;

    /**
     * 现住址 MH01.01.023 C..200 患者本人现住地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处名称和门牌号
     */
    @TableField("ADDR")
    @JsonProperty
    private String addr;

    /**
     * 现住地国标码 MH01.01.024 N9 患者本人现住地址中的的省、自治区或直辖市、市、地区或州、县或区以及乡、镇或城市的街道办事处对应的国标码 参见附件户籍用地区
     */
    @TableField("ADDRCODE")
    @JsonProperty
    private Integer addrcode;

    /**
     * 文化程度 MH01.01.025 N4 必填项，单选 参见6.7文化程度
     */
    @TableField("EDUCATIONBACK")
    @JsonProperty
    private Integer educationback;

    /**
     * 婚姻状况 MH01.01.026 N4 必填项 参见6.18婚姻状况
     */
    @TableField("MARRIAGE")
    @JsonProperty
    private Integer marriage;

    /**
     * 就业情况 MH01.01.027 N4 必填项 参见6.17职业
     */
    @TableField("EMPLOYMENT")
    @JsonProperty
    private Integer employment;

    /**
     * 两系三代精神疾病家族史 MH01.01.028 N4 两系三代精神疾病家族史 参见6.10 有无不详
     */
    @TableField("FAMILY_HISTORY")
    @JsonProperty
    private Integer familyHistory;

    /**
     * 初次发病时间 MH01.01.029 D8 患者本人首次出现精神症状的时间
     */
    @TableField("ATTACH_TIME")
    @JsonProperty
    private LocalDateTime attachTime;

    /**
     * 初次发病时间精确度 MH01.01.030 N1 患者本人首次出现精神症状时间的精确程度 参见6.22时间精确度
     */
    @TableField("FIRST_ILL_TIME_ACCURACY")
    @JsonProperty
    private Integer firstIllTimeAccuracy;

    /**
     * 是否已进行抗精神病药物治疗 MH01.01.031 N2 必填项 参见6.16是否
     */
    @TableField("IF_CURE")
    @JsonProperty
    private Integer ifCure;

    /**
     * 首次抗精神病药治疗时间 MH01.01.032 D8 必填项，录入年月日，最少需录入到年，不可早于初次发病时间，不可晚于当前日期
     */
    @TableField("FIRST_CURE_TIME")
    @JsonProperty

    private LocalDateTime firstCureTime;

    /**
     * 首次抗精神病药治疗时间精确度 MH01.01.033 N1 患者本人首次抗精神病药治疗当日公元纪年日期的精确程度 参见6.22时间精确度
     */
    @TableField("FIRST_CURE_TIME_ACCURACY")
    @JsonProperty
    private Integer firstCureTimeAccuracy;

    /**
     * 既往住院情况 MH01.01.034 N2 必填项，只可录入整数，单位为次
     */
    @TableField("HOSPITAL_STATE_HISTORY")
    @JsonProperty
    private Integer hospitalStateHistory;

    /**
     * 既往关锁情况 MH01.01.035 N2 必填项，只可单选 参见6.25关锁情况
     */
    @TableField("SHUT_STATUS_HISTORY")
    @JsonProperty
    private Integer shutStatusHistory;

    /**
     * 既往危险行为 MH01.01.036 N1 患者的既往危险行为情况，必填项；可多选；如选择"无上述危险行为或风险"，其他选项不可选择，码值用","分隔 参见6.26既往危险行为
     */
    @TableField("PAST_DANGER")
    @JsonProperty
    private String pastDanger;

    /**
     * 既往危险性评估 MH01.01.037 N2 必填项 参见6.21危险行为级别
     */
    @TableField("RISK_PAST")
    @JsonProperty
    private Integer riskPast;

    /**
     * 送诊主体 MH01.01.038 N..2 送患者去就诊的主体代码 参见6.60 送诊主体
     */
    @TableField("SEND_DIAGNOSIS")
    @JsonProperty
    private Integer sendDiagnosis;

    /**
     * 送诊主体—其他 MH01.01.039 C..80 送诊主体为"其他"时，的具体信息
     */
    @TableField("SEND_DIAGNOSIS_OTHER")
    @JsonProperty
    private String sendDiagnosisOther;

    /**
     * 确诊医院 MH01.01.040 C..40 患者本人就诊的医院名称
     */
    @TableField("DIAGNOSIS_HOSPITAL")
    @JsonProperty
    private String diagnosisHospital;

    /**
     * 确诊日期 MH01.01.041 D8 患者本人确诊为精神疾病当日的公元纪年日
     */
    @TableField("DIAGNOSIS_DATE")
    @JsonProperty

    private LocalDateTime diagnosisDate;

    /**
     * 疾病名称及ICD10编码 MH01.01.042 C..20 患者本人的精神疾病诊断类型的代码 参见 6.12ICD10编码
     */
    @TableField("ICD10_CODE")
    @JsonProperty
    private String icd10Code;

    /**
     * 知情同意 MH01.01.043 N1 必填项，如果当前报告卡类型为发病报告患者：符合精神卫生法第三十条第二款第二项情形，此字段默认值为同意。 参见 6.1知情同意书
     */
    @TableField("INFORMED")
    @JsonProperty
    private Integer informed;

    /**
     * 知情同意时间 MH01.01.044 D8 必填项，录入年月日，格式为19800101，不可早于建档日期，不可晚于当前日期
     */
    @TableField("INFORMED_DATE")
    @JsonProperty
    private LocalDateTime informedDate;

    /**
     * 填卡医生 MH01.01.045 C..20 填写本患者报告卡卡的医师在公安管理部门正式登记注册的姓氏和名称
     */
    @TableField("FILL_DOCTOR")
    @JsonProperty
    private String fillDoctor;

    /**
     * 填卡日期 MH01.01.046 D8 填卡医生填写本患者报告卡卡当日的公元纪年日
     */
    @TableField("FILL_DATE")
    @JsonProperty

    private LocalDateTime fillDate;

    /**
     * 报告单位及科室 MH01.01.047 C..40 填卡医生所属医院的科室名称
     */
    @TableField("DEPARTMENT")
    @JsonProperty
    private String department;

    /**
     * 科室联系电话 MH01.01.048 C..13 报告科室的联系电话
     */
    @TableField("DEPARTMENT_PHONE")
    @JsonProperty
    private String departmentPhone;

    /**
     * 报告类型 MH01.01.049 N1 1 发病报告患者：符合精神卫生法第三十条第二款第二项情形 2 按要求登记的六类病种
     */
    @TableField("REPORT_TYPE")
    @JsonProperty
    private Integer reportType;

    /**
     * 信息创建人 MH01.01.050 C..20 信息创建者
     */
    @TableField("INFOCREATER")
    @JsonProperty
    private String infocreater;

    /**
     * 信息创建日期 MH01.01.051 D8 信息创建日期(非数据创建日期)
     */
    @TableField("INFOCREDATE")
    @JsonProperty
    private LocalDateTime infocredate;

    /**
     * 勿需用药 MH01.01.052 N1 当选"是"时，不可填写目前用药情况；当选"否"时必填目前用药情况。 参见6.16 是否
     */
    @TableField("IF_NOMEDICATION")
    @JsonProperty
    private Integer ifNomedication;

}