package com.yin.module.jsyy.service;

import com.yin.module.jsyy.entity.DischargeInfoPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 出院信息表 服务接口
 */
public interface IDischargeInfoService extends IService<DischargeInfoPojo> {
    //新增
    public Result<?> addDischargeInfo(DischargeInfoPojo dischargeInfoPojo);

    //删除
    public Result<?> deleteDischargeInfo(DischargeInfoPojo dischargeInfoPojo);

    //修改
    public Result<?> updateDischargeInfo(DischargeInfoPojo dischargeInfoPojo) ;

    //查询
    public Result<List<DischargeInfoPojo>> getDischargeInfoList(DischargeInfoPojo dischargeInfoPojo);

    //分页查询
    public Result<Page<DischargeInfoPojo>> getDischargeInfoListPage(DischargeInfoPojo dischargeInfoPojo);
}