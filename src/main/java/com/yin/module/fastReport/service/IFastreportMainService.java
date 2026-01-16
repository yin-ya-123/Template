package com.yin.module.fastReport.service;

import com.yin.module.fastReport.entity.FastreportMainPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * FastReport报表主表 服务接口
 */
public interface IFastreportMainService extends IService<FastreportMainPojo> {
    //新增
    public Result<?> addFastreportMain(FastreportMainPojo fastreportMainPojo);

    //删除
    public Result<?> deleteFastreportMain(FastreportMainPojo fastreportMainPojo);

    //修改
    public Result<?> updateFastreportMain(FastreportMainPojo fastreportMainPojo) ;

    //查询
    public Result<List<FastreportMainPojo>> getFastreportMainList(FastreportMainPojo fastreportMainPojo);

    //分页查询
    public Result<Page<FastreportMainPojo>> getFastreportMainListPage(FastreportMainPojo fastreportMainPojo);
}