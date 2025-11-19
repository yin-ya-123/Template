package com.yin.module.jcxx.mapper;

import com.yin.module.jcxx.entity.DictionaryInfoPojo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 通用的字典信息表 Mapper接口
 */
@Mapper
public interface DictionaryInfoMapper extends BaseMapper<DictionaryInfoPojo> {
    
}