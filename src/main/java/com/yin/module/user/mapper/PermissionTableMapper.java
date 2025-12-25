package com.yin.module.user.mapper;

import com.yin.module.user.entity.PermissionTablePojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限表 Mapper接口
 */
@Mapper
public interface PermissionTableMapper extends BaseMapper<PermissionTablePojo> {
    
}