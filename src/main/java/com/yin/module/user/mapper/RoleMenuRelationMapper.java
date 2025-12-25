package com.yin.module.user.mapper;

import com.yin.module.user.entity.RoleMenuRelationPojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 与菜单关联表 Mapper接口
 */
@Mapper
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelationPojo> {
    
}