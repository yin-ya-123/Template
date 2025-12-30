package com.yin.module.jsyy.service;

import com.yin.module.jsyy.entity.PatientReportCardPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 * 患者报告卡主表 服务接口
 */
public interface IPatientReportCardService extends IService<PatientReportCardPojo> {
    //新增
    public Result<?> addPatientReportCard(PatientReportCardPojo patientReportCardPojo);

    //删除
    public Result<?> deletePatientReportCard(PatientReportCardPojo patientReportCardPojo);

    //修改
    public Result<?> updatePatientReportCard(PatientReportCardPojo patientReportCardPojo) ;

    //查询
    public Result<List<PatientReportCardPojo>> getPatientReportCardList(PatientReportCardPojo patientReportCardPojo);

    //分页查询
    public Result<Page<PatientReportCardPojo>> getPatientReportCardListPage(PatientReportCardPojo patientReportCardPojo);

}