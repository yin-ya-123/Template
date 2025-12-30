package com.yin.module.jsyy.controller;

import com.yin.common.Result;
import com.yin.module.jsyy.entity.PatientReportCardPojo;
import com.yin.module.jsyy.service.IPatientReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 患者报告卡主表 前端控制器
 */
@RestController
@RequestMapping("/patientReportCard")
public class PatientReportCardController {

    @Autowired
    private IPatientReportCardService patientReportCardService;

    /*
        新增
    */
    @PostMapping("addPatientReportCard")
    public Result<?> addPatientReportCardPojo(@RequestBody PatientReportCardPojo patientReportCardPojo) {
        return patientReportCardService.addPatientReportCard(patientReportCardPojo);
    }

    //新增
    @PostMapping("addPatientReportCardS")
    @Transactional
    public Result<?> addPatientReportCardPojo(@RequestBody List<PatientReportCardPojo> patientReportCardPojos) {
        Result<?> result = null;
        for (PatientReportCardPojo patientReportCardPojo : patientReportCardPojos) {
            result = patientReportCardService.addPatientReportCard(patientReportCardPojo);
        }
        return result;
    }

    //删除
    @PostMapping("deletePatientReportCard")
    public Result<?> deletePatientReportCardPojo(@RequestBody PatientReportCardPojo patientReportCardPojo) {
        return patientReportCardService.deletePatientReportCard(patientReportCardPojo);
    }

    //修改
    @PostMapping("updatePatientReportCard")
    public Result<?> updatePatientReportCardPojo(@RequestBody PatientReportCardPojo patientReportCardPojo) {
        return patientReportCardService.updatePatientReportCard(patientReportCardPojo);
    }

    //查询
    @PostMapping("getPatientReportCardList")
    public Result<?> getPatientReportCardPojoList(@RequestBody PatientReportCardPojo patientReportCardPojo) {
        return patientReportCardService.getPatientReportCardList(patientReportCardPojo);
    }


    //分页查询
    @PostMapping("getPatientReportCardListPage")
    public Result<?> getPatientReportCardPojoListPage(@RequestBody PatientReportCardPojo patientReportCardPojo) {
        return patientReportCardService.getPatientReportCardListPage(patientReportCardPojo);
    }

}