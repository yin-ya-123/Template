package com.yin.module.jsyy.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.base.entity.Entity;
import com.yin.module.jsyy.entity.HISPatientReportCardPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
@DS("HIS")
public interface HISPatientReportCardMapper extends BaseMapper<HISPatientReportCardPojo> {
    /**
     * 分页查询HIS的患者报告卡信息
     * @param page 分页参数
     * @param pojo 查询参数
     * @return
     */
    public Page<HISPatientReportCardPojo> getList(Page<Entity> page, @Param("pojo") HISPatientReportCardPojo pojo);
}
