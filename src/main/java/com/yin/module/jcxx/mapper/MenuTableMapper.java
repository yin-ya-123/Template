package com.yin.module.jcxx.mapper;

import com.yin.module.jcxx.entity.MenuTablePojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  菜单表  Mapper接口
 */
@Mapper
public interface MenuTableMapper extends BaseMapper<MenuTablePojo> {
    /**
     * 根据用户ID查询对应的菜单权限信息
     * @param userId 用户ID
     * @return 菜单权限信息
     */
    List<MenuTablePojo> getMenuTreeS(@Param("userId") String userId);
}