package com.yin.module.jsyy.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.base.entity.Entity;
import com.yin.base.utils.PageUtils;
import com.yin.common.Result;
import com.yin.common.error.ExceptionEnum;
import com.yin.module.jsyy.entity.HISPatientReportCardPojo;
import com.yin.module.jsyy.mapper.HISPatientReportCardMapper;
import com.yin.module.jsyy.service.IHISPatientReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HISPatientReportCardServiceImpl implements IHISPatientReportCardService {
    @Autowired
    private HISPatientReportCardMapper hisPatientReportCardMapper;

    @Override
    public Result<?> getList(HISPatientReportCardPojo pojo) {
        if (pojo != null) {
            //转换为page类
            Page<Entity> page = PageUtils.convertPage((Entity) pojo);
            if (page == null) {
                System.out.println(pojo);
                return Result.error(ExceptionEnum.CODE_VERIFY_PAGE, null);
            } else {
                Page<HISPatientReportCardPojo> list = hisPatientReportCardMapper.getList(page, pojo);
                return Result.okSel(list);
            }

        }
        return Result.error(ExceptionEnum.CODE_VERIFY, new ArrayList<>());
    }
}
