package com.yin.module.fastReport.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * FastReport报表SQL数据源表
 */
@Data
@TableName("FASTREPORT_SQL_DATASOURCE")
public class FastreportSqlDatasourcePojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据源ID（主键）
     */
    @TableId("DATASOURCE_ID")
    @JsonProperty
    private String datasourceId;

    /**
     * 关联报表ID
     */
    @TableField("REPORT_ID")
    @JsonProperty
    private String reportId;

    /**
     * 数据源名称
     */
    @TableField("DATASOURCE_NAME")
    @JsonProperty
    private String datasourceName;

    /**
     * 数据源SQL语句
     */
    @TableField("SQL_CONTENT")
    @JsonProperty
    private String sqlContent;

    /**
     * 数据源排序号
     */
    @TableField("SORT_NUM")
    @JsonProperty
    private Integer sortNum;

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