package com.yin.module.jsyy.controller;

import com.yin.module.jsyy.entity.PatientReportDrugPojo;
import com.yin.module.jsyy.service.IPatientReportDrugService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.yin.common.Result;
import java.util.List;

/**
 * 报告卡附属药物表 前端控制器
 */
@RestController
@RequestMapping("/patientReportDrug")
public class PatientReportDrugController {

    @Autowired
    private IPatientReportDrugService patientReportDrugService;
    /*
        新增
    */
    @PostMapping("addPatientReportDrug")
    public Result<?> addPatientReportDrugPojo(@RequestBody PatientReportDrugPojo patientReportDrugPojo) {
    return patientReportDrugService.addPatientReportDrug(patientReportDrugPojo);
    }
    //新增
    @PostMapping("addPatientReportDrugS")
    @Transactional
    public Result<?> addPatientReportDrugPojo(@RequestBody List<PatientReportDrugPojo> patientReportDrugPojos) {
        Result<?> result = null;
        for (PatientReportDrugPojo patientReportDrugPojo : patientReportDrugPojos) {
        result = patientReportDrugService.addPatientReportDrug(patientReportDrugPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deletePatientReportDrug")
    public Result<?> deletePatientReportDrugPojo(@RequestBody PatientReportDrugPojo patientReportDrugPojo) {
        return patientReportDrugService.deletePatientReportDrug(patientReportDrugPojo);
    }

    //修改
    @PostMapping("updatePatientReportDrug")
    public Result<?> updatePatientReportDrugPojo(@RequestBody PatientReportDrugPojo patientReportDrugPojo) {
        return patientReportDrugService.updatePatientReportDrug(patientReportDrugPojo);
    }

    //查询
    @PostMapping("getPatientReportDrugList")
    public Result<?> getPatientReportDrugPojoList(@RequestBody PatientReportDrugPojo patientReportDrugPojo) {
        return patientReportDrugService.getPatientReportDrugList(patientReportDrugPojo);
    }


    //分页查询
    @PostMapping("getPatientReportDrugListPage")
    public Result<?> getPatientReportDrugPojoListPage(@RequestBody PatientReportDrugPojo patientReportDrugPojo) {
        return patientReportDrugService.getPatientReportDrugListPage(patientReportDrugPojo);
    }

}