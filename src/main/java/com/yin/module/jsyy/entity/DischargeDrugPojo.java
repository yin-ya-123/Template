package com.yin.module.jsyy.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import com.yin.base.entity.Entity;

/**
 * 出院信息附属药物表
 */
@Data
@TableName("DISCHARGE_DRUG")
public class DischargeDrugPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 出院信息主键 FK C..40 关联出院信息表的外键
     */
    @TableField("FIELD_PK_FK")
    @JsonProperty
    private String fieldPkFk;

    /**
     * 类型 MH01.02.027 C..4 类型01住院用药02用药指导
     */
    @TableField("TYPE")
    @JsonProperty
    private String type;

    /**
     * 序号 MH01.01.053 N1 药物顺序号，从1开始，递增
     */
    @TableField("NUM")
    @JsonProperty
    private Integer num;

    /**
     * 目前用药情况-是否长效 MH01.01.054 N1 目前用药情况-是否长效 参见6.28 是否长效药
     */
    @TableField("IFLONGDRUG")
    @JsonProperty
    private Integer iflongdrug;

    /**
     * 药品名称 MH01.01.055 N20 药品通用名称 查看药品附件
     */
    @TableField("DRUG")
    @JsonProperty
    private Long drug;

    /**
     * 药品编码 MH01.01.056 N20 药品编码 查看药品附件
     */
    @TableField("DRUGCODE")
    @JsonProperty
    private Long drugcode;

    /**
     * 单位 MH01.01.057 N5  查看药品附件
     */
    @TableField("DRUGCOMPANY")
    @JsonProperty
    private Integer drugcompany;

    /**
     * 规格 MH01.01.058 N8  查看药品附件
     */
    @TableField("DRUGOTHER")
    @JsonProperty
    private Integer drugother;

    /**
     * 早 MH01.01.059 N4 选择非长效药时传
     */
    @TableField("DRUGUSE")
    @JsonProperty
    private Integer druguse;

    /**
     * 中 MH01.01.060 N4 选择非长效药时传
     */
    @TableField("DRUGUSE1")
    @JsonProperty
    private Integer druguse1;

    /**
     * 晚 MH01.01.061 N4 选择非长效药时传
     */
    @TableField("DRUGUSE2")
    @JsonProperty
    private Integer druguse2;

    /**
     * 频次 MH01.01.062 N2 选择长效药时传
     */
    @TableField("DRUGFREQUENCY")
    @JsonProperty
    private Integer drugfrequency;

    /**
     * 计量 MH01.01.063 N3 选择长效药时传
     */
    @TableField("DRUGDOSE")
    @JsonProperty
    private Integer drugdose;

    /**
     * 频率 MH01.01.064 N2 选择长效药时传 参见6.29 用药周期
     */
    @TableField("DRUGTIME")
    @JsonProperty
    private Integer drugtime;

}