package com.yin.module.jcxx.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 前端显示类型配置表
 */
@Data
@TableName("TABLE_FIELD_FRONTEND_TYPE")
public class TableFieldFrontendTypePojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;

    /**
     * 表名称
     */
    @TableField("TABLE_NAME")
    @JsonProperty
    private String tableName;

    /**
     * 字段名称
     */
    @TableField("FIELD_NAME")
    @JsonProperty
    private String fieldName;
    @TableField("COLUMN_NAME")
    @JsonProperty
    private String columnName;

    /**
     * SORT
     */
    @TableField("SORT")
    @JsonProperty
    private String sort;
    /**
     * comments
     */
    @TableField("COMMENTS")
    @JsonProperty
    private String comments;
    /**
     * 前端显示组件类型
     */
    @TableField("FRONTEND_TYPE")
    @JsonProperty
    private String frontendType;

    /**
     * 字段对应的JSON数据
     */
    @TableField("JSON_VALUE")
    @JsonProperty
    private String jsonValue;

    /**
     * 逻辑删除标志0未删除1已删除
     */
    @TableField("DEL_FLAG")
//    @TableLogic(delval = "1", value = "0")
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
    @TableField(exist = false)
    @JsonProperty
    private Object locFormField;

    @TableField(exist = false)
    @JsonProperty
    private Object locTableField;
}