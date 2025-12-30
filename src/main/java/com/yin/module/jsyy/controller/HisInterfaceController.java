package com.yin.module.jsyy.controller;

import com.yin.common.Result;
import com.yin.module.jsyy.service.HisInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hisinterface")
public class HisInterfaceController {
    @Autowired
    private HisInterfaceService hisInterfaceService;

    @RequestMapping("jumpAttachByHis")
    public Result<?> jumpAttachByHis() {
        return hisInterfaceService.jumpAttachByHis();
    }

    @RequestMapping("getIdcardNum")
    public Result<?> getIdcardNum() {
        return hisInterfaceService.getIdcardNum();
    }

    @RequestMapping("jumpHospitalByHis")
    public Result<?> jumpHospitalByHis() {
        return hisInterfaceService.jumpHospitalByHis();
    }

    @RequestMapping("getStatus")
    public Result<?> getStatus() {
        return hisInterfaceService.getStatus();
    }
}
