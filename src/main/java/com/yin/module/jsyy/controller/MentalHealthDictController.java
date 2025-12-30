package com.yin.module.jsyy.controller;

import com.yin.common.Result;
import com.yin.module.jsyy.entity.MentalHealthDictPojo;
import com.yin.module.jsyy.service.IMentalHealthDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 精神卫生信息系统-通用字典表 前端控制器
 */
@RestController
@RequestMapping("/mentalHealthDict")
public class MentalHealthDictController {

    @Autowired
    private IMentalHealthDictService mentalHealthDictService;

    /*
        新增
    */
    @PostMapping("addMentalHealthDict")
    public Result<?> addMentalHealthDictPojo(@RequestBody MentalHealthDictPojo mentalHealthDictPojo) {
        return mentalHealthDictService.addMentalHealthDict(mentalHealthDictPojo);
    }

    //新增
    @PostMapping("addMentalHealthDictS")
    @Transactional
    public Result<?> addMentalHealthDictPojo(@RequestBody List<MentalHealthDictPojo> mentalHealthDictPojos) {
        Result<?> result = null;
        for (MentalHealthDictPojo mentalHealthDictPojo : mentalHealthDictPojos) {
            result = mentalHealthDictService.addMentalHealthDict(mentalHealthDictPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteMentalHealthDict")
    public Result<?> deleteMentalHealthDictPojo(@RequestBody MentalHealthDictPojo mentalHealthDictPojo) {
        return mentalHealthDictService.deleteMentalHealthDict(mentalHealthDictPojo);
    }

    //修改
    @PostMapping("updateMentalHealthDict")
    public Result<?> updateMentalHealthDictPojo(@RequestBody MentalHealthDictPojo mentalHealthDictPojo) {
        return mentalHealthDictService.updateMentalHealthDict(mentalHealthDictPojo);
    }

    //查询
    @PostMapping("getMentalHealthDictList")
    public Result<?> getMentalHealthDictPojoList(@RequestBody MentalHealthDictPojo mentalHealthDictPojo) {
        return mentalHealthDictService.getMentalHealthDictList(mentalHealthDictPojo);
    }

    //刷新缓存
    @PostMapping("refreshCache")
    public Result<?> refreshCache() {
        mentalHealthDictService.refreshCache();
        return Result.ok("刷新缓存成功", null);
    }

    //分页查询
    @PostMapping("getMentalHealthDictListPage")
    public Result<?> getMentalHealthDictPojoListPage(@RequestBody MentalHealthDictPojo mentalHealthDictPojo) {
        return mentalHealthDictService.getMentalHealthDictListPage(mentalHealthDictPojo);
    }

}