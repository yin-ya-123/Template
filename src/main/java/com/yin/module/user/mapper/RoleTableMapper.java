package com.yin.module.user.mapper;

import com.yin.module.user.entity.RoleTablePojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *  角色表  Mapper接口
 */
@Mapper
public interface RoleTableMapper extends BaseMapper<RoleTablePojo> {
    
}