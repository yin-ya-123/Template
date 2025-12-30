package com.yin.module.jsyy.service;

import com.yin.common.Result;
import com.yin.module.jsyy.entity.HISPatientReportCardPojo;

public interface IHISPatientReportCardService {
    Result<?> getList(HISPatientReportCardPojo pojo);
}
