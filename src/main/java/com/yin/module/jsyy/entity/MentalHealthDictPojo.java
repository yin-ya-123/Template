package com.yin.module.jsyy.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 精神卫生信息系统-通用字典表
 */
@Data
@TableName("MENTAL_HEALTH_DICT")
public class MentalHealthDictPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    public MentalHealthDictPojo() {

    }

    public MentalHealthDictPojo(String category) {
        setCategory(category);
    }

    /**
     * 主键ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;

    /**
     * 字典类别（如：知情同意书类型、地区类型、康复评估等级等）
     */
    @TableField("CATEGORY")
    @JsonProperty
    private String category;

    /**
     * 字典代码（如"01"）
     */
    @TableField("CODE")
    @JsonProperty
    private String code;

    /**
     * 字典名称
     */
    @TableField("NAME")
    @JsonProperty
    private String name;

    /**
     * 拼音码（助记）
     */
    @TableField("PYM")
    @JsonProperty
    private String pym;

    /**
     * 排序字段
     */
    @TableField("SORT")
    @JsonProperty
    private String sort;

    /**
     * 逻辑删除标志（'0'未删除/'1'已删除）
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 最后更新人账号
     */
    @TableField(value = "UPDATE_USER", fill = FieldFill.UPDATE)
    @JsonProperty
    private String updateUser;

}