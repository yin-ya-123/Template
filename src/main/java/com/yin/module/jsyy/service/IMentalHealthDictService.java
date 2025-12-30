package com.yin.module.jsyy.service;

import com.yin.module.jsyy.entity.MentalHealthDictPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 精神卫生信息系统-通用字典表 服务接口
 */
public interface IMentalHealthDictService extends IService<MentalHealthDictPojo> {
    //新增
    public Result<?> addMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo);

    //删除
    public Result<?> deleteMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo);

    //修改
    public Result<?> updateMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo) ;

    //查询
    public Result<List<MentalHealthDictPojo>> getMentalHealthDictList(MentalHealthDictPojo mentalHealthDictPojo);

    //刷新缓存
    public void refreshCache();
    //分页查询
    public Result<Page<MentalHealthDictPojo>> getMentalHealthDictListPage(MentalHealthDictPojo mentalHealthDictPojo);
}