package com.yin.module.jsyy.service;

import com.yin.module.jsyy.entity.DischargeDrugPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 出院信息附属药物表 服务接口
 */
public interface IDischargeDrugService extends IService<DischargeDrugPojo> {
    //新增
    public Result<?> addDischargeDrug(DischargeDrugPojo dischargeDrugPojo);

    //删除
    public Result<?> deleteDischargeDrug(DischargeDrugPojo dischargeDrugPojo);

    //修改
    public Result<?> updateDischargeDrug(DischargeDrugPojo dischargeDrugPojo) ;

    //查询
    public Result<List<DischargeDrugPojo>> getDischargeDrugList(DischargeDrugPojo dischargeDrugPojo);

    //分页查询
    public Result<Page<DischargeDrugPojo>> getDischargeDrugListPage(DischargeDrugPojo dischargeDrugPojo);
}