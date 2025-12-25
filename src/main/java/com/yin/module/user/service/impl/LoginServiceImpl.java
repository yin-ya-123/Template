package com.yin.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yin.common.Result;
import com.yin.common.error.ExceptionEnum;
import com.yin.module.jcxx.entity.MenuTablePojo;
import com.yin.module.jcxx.service.IMenuTableService;
import com.yin.module.user.entity.UserTablePojo;
import com.yin.module.user.service.ILoginService;
import com.yin.module.user.service.IUserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private IUserTableService userTableService;
    @Autowired
    private IMenuTableService menuTableService;

    @Override
    public Result<?> login(String username, String password) {
        //参数校验
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return Result.error(ExceptionEnum.CODE_VERIFY, null);
        }
        LambdaQueryWrapper<UserTablePojo> userTablePojoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userTablePojoLambdaQueryWrapper.eq(UserTablePojo::getUserGh, username)
                .eq(UserTablePojo::getPassword, password);
        UserTablePojo one = userTableService.getOne(userTablePojoLambdaQueryWrapper);
        if (one != null) {
            //登录成功获取菜单信息
            List<MenuTablePojo> menuTreeS = menuTableService.getMenuTreeS(one.getId());
            one.setMenuTablePojoChildren(menuTreeS);
            return Result.ok("登录成功", one);
        } else {
            return Result.error("账号或密码不对", null);
        }
    }
}
