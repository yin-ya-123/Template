package com.yin.module.fastReport.service;

import com.yin.module.fastReport.entity.FastreportParamPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * FastReport报表参数信息表 服务接口
 */
public interface IFastreportParamService extends IService<FastreportParamPojo> {
    //新增
    public Result<?> addFastreportParam(FastreportParamPojo fastreportParamPojo);

    //删除
    public Result<?> deleteFastreportParam(FastreportParamPojo fastreportParamPojo);

    //修改
    public Result<?> updateFastreportParam(FastreportParamPojo fastreportParamPojo) ;

    //查询
    public Result<List<FastreportParamPojo>> getFastreportParamList(FastreportParamPojo fastreportParamPojo);

    //分页查询
    public Result<Page<FastreportParamPojo>> getFastreportParamListPage(FastreportParamPojo fastreportParamPojo);
}