package com.yin.module.jsyy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 出院信息表
 */
@Data
@TableName("DISCHARGE_INFO")
public class DischargeInfoPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 出院信息的主键 MH01.02.001 C..40 uuid
     */
    @TableId("FIELD_PK")
    @JsonProperty
    private String fieldPk;

    /**
     * 患者主键 MH01.02.002 C..40 uuid
     */
    @TableField("BASEINFO_FIELD_PK_FK")
    @JsonProperty
    private String baseinfoFieldPkFk;

    /**
     * 报告地区 MH01.02.003 N8 报告单位所属县区编码 参照附件地区机构
     */
    @TableField("ZONECODE")
    @JsonProperty
    private Integer zonecode;

    /**
     * 报告单位 MH01.02.004 N9 报告单位的组织机构编码 参照附件地区机构
     */
    @TableField("ORGCODE")
    @JsonProperty
    private Integer orgcode;

    /**
     * 卡片编号（患者报告卡号） MH01.02.005 N14 按照某一特定编码规则赋予本人患者报告卡卡的顺序号
     */
    @TableField("CARD_NO")
    @JsonProperty
    private Long cardNo;

    /**
     * 患者报告卡主键 MH01.02.006 C..40 患者报告卡主键
     */
    @TableField("ATTACH_FIELD_PK_FK")
    @JsonProperty
    private String attachFieldPkFk;

    /**
     * 病案号—住院 MH01.02.007 C..40 患者本人住院病案号
     */
    @TableField("INHOSPITAL_NO")
    @JsonProperty
    private String inhospitalNo;

    /**
     * 患者姓名 MH01.02.008 C..20 患者本人在公安管理部门正式登记注册的姓氏和名称
     */
    @TableField("PATIENT_NAME")
    @JsonProperty
    private String patientName;

    /**
     * 性别 MH01.02.009 N1 患者本人生理性别的代码 参见6.8性别
     */
    @TableField("SEX")
    @JsonProperty
    private Integer sex;

    /**
     * 出生日期 MH01.02.010 D8 患者本人出生当日的公元纪年日期
     */
    @TableField("BIRTHDAY_DATE")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime birthdayDate;

    /**
     * 证件类型 MH01.02.011 N1 患者证件类型 参见6.6证件类型
     */
    @TableField("DOCUMENT_TYPE")
    @JsonProperty
    private Integer documentType;

    /**
     * 证件号码 MH01.02.012 C..18 患者证件号码，如果有身份证号，录入身份证号
     */
    @TableField("IDCARD_NUM")
    @JsonProperty
    private String idcardNum;

    /**
     * 国籍 MH01.02.013 C4 患者国籍，患者是国外人时，为必填项。患者是中国人时，为空。
     */
    @TableField("NATIONALITY")
    @JsonProperty
    private String nationality;

    /**
     * 入院日期 MH01.02.014 D8 患者本人入住医院当日的公元纪年日
     */
    @TableField("TO_HOSPITAL")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime toHospital;

    /**
     * 出院日期 MH01.02.015 D8 患者本人出医院当日的公元纪年日
     */
    @TableField("OUT_HOSPITAL")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime outHospital;

    /**
     * 既往治疗情况—曾住精神专科医院次数 MH01.02.016 N..4 患者本人曾住精神专科医院次数
     */
    @TableField("IN_MENTAL_HOSPITAL")
    @JsonProperty
    private Integer inMentalHospital;

    /**
     * 出院诊断 MH01.02.017 C..20 患者本人出院时的精神疾病诊断类型的代码 参见6.12ICD10编码
     */
    @TableField("DIAGNOSIS")
    @JsonProperty
    private String diagnosis;

    /**
     * 确诊日期 MH01.02.018 D8 患者本人确诊为精神疾病当日的公元纪年日
     */
    @TableField("DIAGNOSIS_DATE")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime diagnosisDate;

    /**
     * 既往危险行为 MH01.02.019 N1 患者的既往危险行为情况，必填项；可多选；如选择"无上述危险行为或风险"，其他选项不可选择，码值用","分隔 参见6.26既往危险行为
     */
    @TableField("PAST_DANGER")
    @JsonProperty
    private Integer pastDanger;

    /**
     * 住院疗效 MH01.02.020 N1 患者本次住院的治疗效果代码 参见6.23治疗效果
     */
    @TableField("EFFECT")
    @JsonProperty
    private Integer effect;

    /**
     * 康复措施 MH01.02.021 N1 患者本人出院后的康复措施代码 参见 6.31 康复措施
     */
    @TableField("NEXT_MEASURES")
    @JsonProperty
    private Integer nextMeasures;

    /**
     * 康复措施其他请注明 MH01.02.022 C..80 康复措施选其他后的注明
     */
    @TableField("NEXT_MEASURES_INST")
    @JsonProperty
    private String nextMeasuresInst;

    /**
     * 其他注意事项 MH01.02.023 C..80 患者本人下一步治疗方案的其他注意事项
     */
    @TableField("OTHER_INST")
    @JsonProperty
    private String otherInst;

    /**
     * 经治医生 MH01.02.024 C..20 患者本人治疗医师的姓名
     */
    @TableField("DOCTOR")
    @JsonProperty
    private String doctor;

    /**
     * 联系电话 MH01.02.025 C..13 经治医生的联系电话
     */
    @TableField("DOCTOR_PHONE")
    @JsonProperty
    private String doctorPhone;

    /**
     * 签字日期（填表日期） MH01.02.026 D8 填写本出院信息单时的公元纪年月日
     */
    @TableField("FILL_DATE")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime fillDate;

}