package com.yin.module.fastReport.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * FastReport报表参数信息表
 */
@Data
@TableName("FASTREPORT_PARAM")
public class FastreportParamPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 参数ID（主键）
     */
    @TableId("PARAM_ID")
    @JsonProperty
    private String paramId;

    /**
     * 关联报表主表的REPORT_ID
     */
    @TableField("REPORT_ID")
    @JsonProperty
    private String reportId;

    /**
     * 参数名称
     */
    @TableField("PARAM_NAME")
    @JsonProperty
    private String paramName;

    /**
     * 参数编码（同一报表下唯一）
     */
    @TableField("PARAM_CODE")
    @JsonProperty
    private String paramCode;

    /**
     * 参数数据类型（如DATE/VARCHAR2/NUMBER）
     */
    @TableField("PARAM_TYPE")
    @JsonProperty
    private String paramType;

    /**
     * 参数默认值
     */
    @TableField("DEFAULT_VALUE")
    @JsonProperty
    private String defaultValue;

    /**
     * 参数描述
     */
    @TableField("PARAM_DESC")
    @JsonProperty
    private String paramDesc;

    /**
     * 是否必填（1:是 0:否）
     */
    @TableField("IS_REQUIRED")
    @JsonProperty
    private String isRequired;

    /**
     * 参数排序号
     */
    @TableField("SORT_NUM")
    @JsonProperty
    private Integer sortNum;

    /**
     * 逻辑删除标志（'0':未删除 '1':已删除）
     */
    @TableField("DEL_FLAG")
    @JsonProperty
    private String delFlag;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @JsonProperty
    private LocalDateTime createTime;

    /**
     * 创建人账号
     */
    @TableField(value = "CREATE_USER", fill = FieldFill.INSERT)
    @JsonProperty
    private String createUser;

    /**
     * 最后更新时间
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.UPDATE)
    @JsonProperty
    private LocalDateTime updateTime;

    /**
     * 最后更新人账号
     */
    @TableField(value = "UPDATE_USER", fill = FieldFill.UPDATE)
    @JsonProperty
    private String updateUser;

}