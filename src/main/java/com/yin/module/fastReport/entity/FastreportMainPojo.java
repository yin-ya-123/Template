package com.yin.module.fastReport.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * FastReport报表主表
 */
@Data
@TableName("FASTREPORT_MAIN")
public class FastreportMainPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 报表ID（主键）
     */
    @TableId("REPORT_ID")
    @JsonProperty
    private String reportId;

    /**
     * 报表名称
     */
    @TableField("REPORT_NAME")
    @JsonProperty
    private String reportName;

    /**
     * 报表编码（唯一）
     */
    @TableField("REPORT_CODE")
    @JsonProperty
    private String reportCode;

    /**
     * FastReport模板文件（二进制存储）
     */
    @TableField("TEMPLATE_CONTENT")
    @JsonProperty
    private byte[] templateContent;

    /**
     * 报表模板描述
     */
    @TableField("TEMPLATE_DESC")
    @JsonProperty
    private String templateDesc;

    /**
     * 报表状态（1:启用 0:禁用）
     */
    @TableField("STATUS")
    @JsonProperty
    private String status;

    /**
     * 逻辑删除标志（'0'：未删除，'1'：已删除）
     */
    @TableField("DEL_FLAG")
    @TableLogic(delval = "1", value = "0")
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