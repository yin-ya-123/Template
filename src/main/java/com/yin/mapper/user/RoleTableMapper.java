package com.yin.mapper.user;

import com.yin.entity.user.RoleTablePojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *  角色表  Mapper接口
 */
@Mapper
public interface RoleTableMapper extends BaseMapper<RoleTablePojo> {
    
}