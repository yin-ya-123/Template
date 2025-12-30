package com.yin.module.jsyy.service;

import com.yin.module.jsyy.entity.PatientReportDrugPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 报告卡附属药物表 服务接口
 */
public interface IPatientReportDrugService extends IService<PatientReportDrugPojo> {
    //新增
    public Result<?> addPatientReportDrug(PatientReportDrugPojo patientReportDrugPojo);

    //删除
    public Result<?> deletePatientReportDrug(PatientReportDrugPojo patientReportDrugPojo);

    //修改
    public Result<?> updatePatientReportDrug(PatientReportDrugPojo patientReportDrugPojo) ;

    //查询
    public Result<List<PatientReportDrugPojo>> getPatientReportDrugList(PatientReportDrugPojo patientReportDrugPojo);

    //分页查询
    public Result<Page<PatientReportDrugPojo>> getPatientReportDrugListPage(PatientReportDrugPojo patientReportDrugPojo);
}