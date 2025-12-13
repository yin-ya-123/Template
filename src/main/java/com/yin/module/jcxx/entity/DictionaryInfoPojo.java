package com.yin.module.jcxx.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用的字典信息表
 */
@Data
@TableName("DICTIONARY_INFO")
public class DictionaryInfoPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;
    /**
     * 字典值
     */
    @TableField("DICT_VALUE")
    @JsonProperty
    private String dictValue;
    /**
     * 字典描述
     */
    @TableField("DICT_SM")
    @JsonProperty
    private String dictSm;
    /**
     * 字典类型
     */
    @TableField("DICT_LX")
    @JsonProperty
    private String dictLx;
    /**
     * 拼音码 / 助记码
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