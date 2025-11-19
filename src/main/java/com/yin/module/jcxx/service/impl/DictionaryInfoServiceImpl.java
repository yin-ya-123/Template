package com.yin.module.jcxx.service.impl;

import com.yin.module.jcxx.entity.DictionaryInfoPojo;
import com.yin.module.jcxx.service.IDictionaryInfoService;
import com.yin.module.jcxx.mapper.DictionaryInfoMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * 通用的字典信息表 服务实现类
 */
@Service
public class DictionaryInfoServiceImpl extends BaseServiceImpl<DictionaryInfoMapper,DictionaryInfoPojo> implements IDictionaryInfoService {

    /**
      常用查询条件
      * @param dictionaryInfoPojo
    */
    public LambdaQueryWrapper<DictionaryInfoPojo> dictionaryInfoLambdaQueryWrapper(DictionaryInfoPojo dictionaryInfoPojo) {
        LambdaQueryWrapper<DictionaryInfoPojo> dictionaryInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dictionaryInfoPojo.getId() != null && !dictionaryInfoPojo.getId().isEmpty()) {
            dictionaryInfoLambdaQueryWrapper.eq(DictionaryInfoPojo::getId,dictionaryInfoPojo.getId());
        }
        if (dictionaryInfoPojo.getDictSm() != null && !dictionaryInfoPojo.getDictSm().isEmpty()) {
            dictionaryInfoLambdaQueryWrapper.eq(DictionaryInfoPojo::getDictSm,dictionaryInfoPojo.getDictSm());
        }
        if (dictionaryInfoPojo.getPym() != null && !dictionaryInfoPojo.getPym().isEmpty()) {
            dictionaryInfoLambdaQueryWrapper.eq(DictionaryInfoPojo::getPym,dictionaryInfoPojo.getPym());
        }
        if (dictionaryInfoPojo.getSort() != null && !dictionaryInfoPojo.getSort().isEmpty()) {
            dictionaryInfoLambdaQueryWrapper.eq(DictionaryInfoPojo::getSort,dictionaryInfoPojo.getSort());
        }
        if (dictionaryInfoPojo.getDelFlag() != null && !dictionaryInfoPojo.getDelFlag().isEmpty()) {
            dictionaryInfoLambdaQueryWrapper.eq(DictionaryInfoPojo::getDelFlag,dictionaryInfoPojo.getDelFlag());
        }
        return dictionaryInfoLambdaQueryWrapper;
    }
    /**
    * 参数校验
    * @param dictionaryInfoPojo 实体
    * @param type  操作类型 0 新增 1 删除 2修改
    * @return 标志
    */
    public String dictionaryInfoVerifyS(DictionaryInfoPojo dictionaryInfoPojo, SysEnum type) {
        if ((dictionaryInfoPojo.getId() == null || dictionaryInfoPojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return " 主键 ID为空";
        }
        if (dictionaryInfoPojo.getDictSm() == null || dictionaryInfoPojo.getDictSm().isEmpty()) {
            return "字典描述为空";
        }
        if (dictionaryInfoPojo.getPym() == null || dictionaryInfoPojo.getPym().isEmpty()) {
            return " 拼音码 / 助记码 为空";
        }
        if (dictionaryInfoPojo.getSort() == null || dictionaryInfoPojo.getSort().isEmpty()) {
            return " 排序字段 为空";
        }
        if (dictionaryInfoPojo.getDelFlag() == null || dictionaryInfoPojo.getDelFlag().isEmpty()) {
            return " 逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }
    //新增
    @Override
    public Result<?> addDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo) {
    return insert(dictionaryInfoPojo, dictionaryInfoVerifyS(dictionaryInfoPojo, SysEnum.SAVE), dictionaryInfoLambdaQueryWrapper(dictionaryInfoPojo));
    }
    //删除
    @Override
    public Result<?> deleteDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo) {
    return delete(dictionaryInfoPojo, dictionaryInfoVerifyS(dictionaryInfoPojo, SysEnum.DELETE));
    }
    //修改
    @Override
    public Result<?> updateDictionaryInfo(DictionaryInfoPojo dictionaryInfoPojo) {
    return update(dictionaryInfoPojo, dictionaryInfoVerifyS(dictionaryInfoPojo, SysEnum.UPDATE));
    }
    //查询
    @Override
    public Result<List<DictionaryInfoPojo>> getDictionaryInfoList(DictionaryInfoPojo dictionaryInfoPojo) {
        return selectFORList(dictionaryInfoLambdaQueryWrapper(dictionaryInfoPojo));
    }
    //分页查询
    @Override
    public Result<Page<DictionaryInfoPojo>> getDictionaryInfoListPage(DictionaryInfoPojo dictionaryInfoPojo) {
        return selectPage(dictionaryInfoPojo, dictionaryInfoLambdaQueryWrapper(dictionaryInfoPojo));
    }
}