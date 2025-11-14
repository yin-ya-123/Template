package com.yin.mapper.user;

import com.yin.entity.user.UserTablePojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *  用户表  Mapper接口
 */
@Mapper
public interface UserTableMapper extends BaseMapper<UserTablePojo> {
    
}