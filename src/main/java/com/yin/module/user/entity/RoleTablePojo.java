package com.yin.module.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import com.yin.base.entity.Entity;
import java.util.Date;

/**
 *  角色表 
 */
@Data
@TableName("ROLE_TABLE")
public class RoleTablePojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  主键 ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;

    /**
     *  角色名称 
     */
    @TableField("ROLE_NAME")
    @JsonProperty
    private String roleName;

    /**
     *  角色描述 
     */
    @TableField("ROLE_DESC")
    @JsonProperty
    private String roleDesc;

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
    @JsonProperty
    private String delFlag;

    /**
     *  创建时间 
     */
    @TableField("CREATE_TIME")
    @JsonProperty
    private Date createTime;

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
    private Date updateTime;

    /**
     *  最后更新人账号 
     */
    @TableField("UPDATE_USER")
    @JsonProperty
    private String updateUser;

}