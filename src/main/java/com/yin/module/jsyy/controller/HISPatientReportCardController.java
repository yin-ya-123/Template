package com.yin.module.jsyy.controller;

import com.yin.common.Result;
import com.yin.module.jsyy.entity.HISPatientReportCardPojo;
import com.yin.module.jsyy.service.IHISPatientReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/his")
public class HISPatientReportCardController {
    @Autowired
    private IHISPatientReportCardService hisPatientReportCardService;

    @RequestMapping("/getList")
    public Result<?> getList(@RequestBody HISPatientReportCardPojo pojo) {
        return hisPatientReportCardService.getList(pojo);
    }
}
