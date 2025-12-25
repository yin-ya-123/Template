package com.yin.module.user.service;

import com.yin.common.Result;

public interface ILoginService {
    public Result<?> login(String username, String password);
}
