package com.yin.module.jsyy.service;

import com.yin.common.Result;

public interface HisInterfaceService {
    /**
     * 报告卡集成页面调用
     */
    public Result<?> jumpAttachByHis();

    /**
     * 获取当前患者是否需要填报
     */
    public Result<?> getIdcardNum();

    /**
     * 出院单集成页面调用
     */
    public Result<?> jumpHospitalByHis();

    /**
     * 获取是否填报完成
     */
    public Result<?> getStatus();
}
