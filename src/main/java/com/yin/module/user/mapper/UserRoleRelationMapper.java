package com.yin.module.user.mapper;

import com.yin.module.user.entity.UserRoleRelationPojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色关联表 Mapper接口
 */
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelationPojo> {
    
}