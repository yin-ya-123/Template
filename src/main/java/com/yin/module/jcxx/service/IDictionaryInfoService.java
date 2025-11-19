package com.yin.module.jcxx.service;

import com.yin.module.jcxx.entity.DictionaryInfoPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 通用的字典信息表 服务接口
 */
public interface IDictionaryInfoService extends IService<DictionaryInfoPojo> {
    //新增
    public Result<?> addDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo);

    //删除
    public Result<?> deleteDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo);

    //修改
    public Result<?> updateDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo) ;

    //查询
    public Result<List<DictionaryInfoPojo>> getDictionaryInfoList(DictionaryInfoPojo dictionaryInfoPojo);

    //分页查询
    public Result<Page<DictionaryInfoPojo>> getDictionaryInfoListPage(DictionaryInfoPojo dictionaryInfoPojo);
}