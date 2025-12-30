package com.yin.module.jsyy.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.yin.base.utils.http.Http;
import com.yin.common.Result;
import com.yin.module.jsyy.entity.MentalHealthDictPojo;
import com.yin.module.jsyy.service.HisInterfaceService;
import com.yin.module.jsyy.service.IMentalHealthDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.HashMap;

@Service
public class HisInterfaceServiceImpl implements HisInterfaceService {
    @Autowired
    private IMentalHealthDictService mentalHealthDictService;

    @Override
    public Result<?> jumpAttachByHis() {
        MentalHealthDictPojo mentalHealthDictPojo = getMentalHealthDictPojo();
        String url = mentalHealthDictPojo.getCode() + "hisinterface/his/jumpAttachByHis";
        HashMap<String, Object> par = new HashMap<>();
        JSONArray drugObjects = JSONUtil.parseArray("[\n" +
                "    {\n" +
                "        \"num\": 1,\n" +
                "        \"ifLongdrug\": \"0\",\n" +
                "        \"drug\": \"阿戈美拉汀片\",\n" +
                "        \"drugCode\": \"D002002\",\n" +
                "        \"drugCompany\": \"mg\",\n" +
                "        \"drugOther\": \"25mg\",\n" +
                "        \"drugUsage\": \"25\",\n" +
                "        \"drugUsage1\": \"50\",\n" +
                "        \"drugUsage2\": \"12.5\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"num\": 2,\n" +
                "        \"ifLongdrug\": \"1\",\n" +
                "        \"drug\": \"癸酸氟哌啶醇注射液/哈力多\",\n" +
                "        \"drugCode\": \"D002002\",\n" +
                "        \"drugCompany\": \"mg\",\n" +
                "        \"drugOther\": \"50mg\",\n" +
                "        \"drugTime\": \"01\",\n" +
                "        \"drugDose\": \"50\",\n" +
                "        \"drugFrequency\": \"1\"\n" +
                "    }\n" +
                "]");
        String encode = URLEncoder.encode(drugObjects.toString());
        par.put("medications", encode);
        try {
            String execute = Http.get(url)
                    .data(par)
                    .execute();
            return Result.ok("成功", execute);
        } catch (Exception e) {
            return Result.error("请求失败", e.getMessage());
        }

    }

    @Override
    public Result<?> getIdcardNum() {
        MentalHealthDictPojo mentalHealthDictPojo = getMentalHealthDictPojo();
        String url = mentalHealthDictPojo.getCode() + "hisinterface/his/getIdcardNum";
        String execute = null;
        try {
            execute = Http.post(url).execute();
            return Result.ok("成功", execute);
        } catch (Exception e) {
            return Result.error("请求失败", e.getMessage());
        }
    }

    @Override
    public Result<?> jumpHospitalByHis() {
        MentalHealthDictPojo mentalHealthDictPojo = getMentalHealthDictPojo();
        String url = mentalHealthDictPojo.getCode() + "hisinterface/his/jumpHospitalByHis";
        return null;
    }

    @Override
    public Result<?> getStatus() {
        MentalHealthDictPojo mentalHealthDictPojo = getMentalHealthDictPojo();
        String url = mentalHealthDictPojo.getCode() + "hisinterface/his/getStatus";
        return null;
    }

    private MentalHealthDictPojo getMentalHealthDictPojo() {
        MentalHealthDictPojo mentalHealthDictPojo = new MentalHealthDictPojo();
        mentalHealthDictPojo.setCategory("IP");
        return mentalHealthDictService.getMentalHealthDictList(mentalHealthDictPojo).getData().get(0);
    }
}
