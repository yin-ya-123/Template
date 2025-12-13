package com.yin.module.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  用户表 
 */
@Data
@TableName("USER_TABLE")
public class UserTablePojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  主键 ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;

    /**
     *  用户名 
     */
    @TableField("USER_NAME")
    @JsonProperty
    private String userName;

    /**
     *  用户密码 
     */
    @TableField("PASSWORD")
    @JsonProperty
    private String password;

    /**
     *  拼音码 / 助记码 
     */
    @TableField("PYM")
    @JsonProperty
    private String pym;

    /**
     *  排序字段 
     */
    @TableField("SORT")
    @JsonProperty
    private String sort;

    /**
     *  逻辑删除标志（'0'：未删除，'1'：已删除）
     */
    @TableField("DEL_FLAG")
    @TableLogic(delval = "1", value = "0")
    @JsonProperty
    private String delFlag;

    /**
     *  创建时间 
     */
    @TableField("CREATE_TIME")
    @JsonProperty
    private LocalDateTime createTime;

    /**
     *  创建人账号 
     */
    @TableField("CREATE_USER")
    @JsonProperty
    private String createUser;

    /**
     *  最后更新时间 
     */
    @TableField("UPDATE_TIME")
    @JsonProperty
    private LocalDateTime updateTime;

    /**
     *  最后更新人账号 
     */
    @TableField("UPDATE_USER")
    @JsonProperty
    private String updateUser;

}