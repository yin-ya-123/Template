package com.yin.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yin.base.entity.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 与菜单关联表
 */
@Data
@TableName("ROLE_MENU_RELATION")
public class RoleMenuRelationPojo extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    @TableId("ID")
    @JsonProperty
    private String id;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    @JsonProperty
    private String roleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    @JsonProperty
    private String roleName;

    /**
     * 菜单 ID
     */
    @TableField("MENU_ID")
    @JsonProperty
    private String menuId;

    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    @JsonProperty
    private String menuName;

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