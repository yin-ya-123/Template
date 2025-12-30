package com.yin.module.jsyy.service.impl;

import com.yin.module.jsyy.entity.MentalHealthDictPojo;
import com.yin.module.jsyy.service.IMentalHealthDictService;
import com.yin.module.jsyy.mapper.MentalHealthDictMapper;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.List;

/**
 * 精神卫生信息系统-通用字典表 服务实现类
 */
@Service
public class MentalHealthDictServiceImpl extends BaseServiceImpl<MentalHealthDictMapper, MentalHealthDictPojo> implements IMentalHealthDictService {
    //缓存
    private HashMap<String,Result<List<MentalHealthDictPojo>>> cache = new HashMap<>();

    /**
     * 常用查询条件
     *
     * @param mentalHealthDictPojo
     */
    public LambdaQueryWrapper<MentalHealthDictPojo> mentalHealthDictLambdaQueryWrapper(MentalHealthDictPojo mentalHealthDictPojo) {
        LambdaQueryWrapper<MentalHealthDictPojo> mentalHealthDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (mentalHealthDictPojo.getId() != null && !mentalHealthDictPojo.getId().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getId, mentalHealthDictPojo.getId());
        }
        if (mentalHealthDictPojo.getCategory() != null && !mentalHealthDictPojo.getCategory().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getCategory, mentalHealthDictPojo.getCategory());
        }
        if (mentalHealthDictPojo.getCode() != null && !mentalHealthDictPojo.getCode().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getCode, mentalHealthDictPojo.getCode());
        }
        if (mentalHealthDictPojo.getName() != null && !mentalHealthDictPojo.getName().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getName, mentalHealthDictPojo.getName());
        }
        if (mentalHealthDictPojo.getPym() != null && !mentalHealthDictPojo.getPym().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getPym, mentalHealthDictPojo.getPym());
        }
        if (mentalHealthDictPojo.getSort() != null && !mentalHealthDictPojo.getSort().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getSort, mentalHealthDictPojo.getSort());
        }
        if (mentalHealthDictPojo.getDelFlag() != null && !mentalHealthDictPojo.getDelFlag().isEmpty()) {
            mentalHealthDictLambdaQueryWrapper.eq(MentalHealthDictPojo::getDelFlag, mentalHealthDictPojo.getDelFlag());
        }
        return mentalHealthDictLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param mentalHealthDictPojo 实体
     * @param type                 操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String mentalHealthDictVerifyS(MentalHealthDictPojo mentalHealthDictPojo, SysEnum type) {
        if ((mentalHealthDictPojo.getId() == null || mentalHealthDictPojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return "主键ID为空";
        }
        if (mentalHealthDictPojo.getCategory() == null || mentalHealthDictPojo.getCategory().isEmpty()) {
            return "字典类别（如：知情同意书类型、地区类型、康复评估等级等）为空";
        }
        if (mentalHealthDictPojo.getCode() == null || mentalHealthDictPojo.getCode().isEmpty()) {
            return "字典代码（如01）为空";
        }
        if (mentalHealthDictPojo.getName() == null || mentalHealthDictPojo.getName().isEmpty()) {
            return "字典名称为空";
        }
        if (mentalHealthDictPojo.getPym() == null || mentalHealthDictPojo.getPym().isEmpty()) {
            return "拼音码（助记）为空";
        }
        if (mentalHealthDictPojo.getSort() == null || mentalHealthDictPojo.getSort().isEmpty()) {
            return "排序字段为空";
        }
        if (mentalHealthDictPojo.getDelFlag() == null || mentalHealthDictPojo.getDelFlag().isEmpty()) {
            return "逻辑删除标志（'0'未删除/'1'已删除）为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo) {
        return insert(mentalHealthDictPojo, mentalHealthDictVerifyS(mentalHealthDictPojo, SysEnum.SAVE), mentalHealthDictLambdaQueryWrapper(mentalHealthDictPojo));
    }

    //删除
    @Override
    public Result<?> deleteMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo) {
        return delete(mentalHealthDictPojo, mentalHealthDictVerifyS(mentalHealthDictPojo, SysEnum.DELETE));
    }

    //修改
    @Override
    public Result<?> updateMentalHealthDict(MentalHealthDictPojo mentalHealthDictPojo) {
        return update(mentalHealthDictPojo, mentalHealthDictVerifyS(mentalHealthDictPojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<MentalHealthDictPojo>> getMentalHealthDictList(MentalHealthDictPojo mentalHealthDictPojo) {
        if (null != cache && !cache.isEmpty() && cache.get(mentalHealthDictPojo.getCategory()) != null) {
            return cache.get(mentalHealthDictPojo.getCategory());
        } else {
            Result<List<MentalHealthDictPojo>> listResult = selectFORList(mentalHealthDictLambdaQueryWrapper(mentalHealthDictPojo));
            cache.put(mentalHealthDictPojo.getCategory(),listResult);
            return listResult;
        }
    }
    //刷新缓存
    @Override
    public void refreshCache() {
        cache.clear();
    }

    //分页查询
    @Override
    public Result<Page<MentalHealthDictPojo>> getMentalHealthDictListPage(MentalHealthDictPojo mentalHealthDictPojo) {
        return selectPage(mentalHealthDictPojo, mentalHealthDictLambdaQueryWrapper(mentalHealthDictPojo));
    }
}