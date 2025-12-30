package com.yin.module.jcxx.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("V_TABLE_COL")
public class DictionTableInfo extends Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * TABLE_NAME
     * COLUMN_NAME
     * DATA_TYPE
     * DATA_LENGTH
     * DATA_PRECISION
     * DATA_SCALE
     * NULLABLE
     * COMMENTS
     */
    @TableField("TABLE_NAME")
    @JsonProperty
    private String tableName;

    @TableField("COLUMN_NAME")
    @JsonProperty
    private String columnName;
    @TableField(exist = false)
    @JsonProperty
    private String javaColumnName;
    @TableField("DATA_TYPE")
    @JsonProperty
    private String dataType;

    @TableField("DATA_LENGTH")
    @JsonProperty
    private String dataLength;

    @TableField("DATA_PRECISION")
    @JsonProperty
    private String dataPrecision;
    @TableField("DATA_SCALE")
    @JsonProperty
    private String dataScale;
    @TableField("NULLABLE")
    @JsonProperty
    private String nullable;
    @TableField("COMMENTS")
    @JsonProperty
    private String comments;

    @TableField(exist = false)
    @JsonProperty
    private Object locFormField;

    @TableField(exist = false)
    @JsonProperty
    private Object locTableField;
}
