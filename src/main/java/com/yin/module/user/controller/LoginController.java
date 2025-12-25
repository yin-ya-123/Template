package com.yin.module.user.controller;

import com.yin.common.Result;
import com.yin.module.user.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> params) {
        if (params == null) {
            return Result.error("参数错误", null);
        }
        return loginService.login(params.get("username"), params.get("password"));
    }
}
