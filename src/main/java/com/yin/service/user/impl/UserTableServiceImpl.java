package com.yin.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yin.common.Result;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.yin.entity.user.UserTablePojo;
import com.yin.mapper.user.UserTableMapper;
import com.yin.service.user.IUserTableService;
import com.yin.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表  服务实现类
 */
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTablePojo> implements IUserTableService {
    @Autowired
    private UserTableMapper userTableMapper;
    @Autowired
    private ServiceUtils<UserTablePojo> serviceUtils;

    /**
     * 常用查询条件
     *
     * @param userTablePojo
     */
    public LambdaQueryWrapper<UserTablePojo> userTableLambdaQueryWrapper(UserTablePojo userTablePojo) {
        LambdaQueryWrapper<UserTablePojo> userTableLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (userTablePojo.getId() != null && !userTablePojo.getId().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getId, userTablePojo.getId());
        }
        if (userTablePojo.getUserName() != null && !userTablePojo.getUserName().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getUserName, userTablePojo.getUserName());
        }
        if (userTablePojo.getPassword() != null && !userTablePojo.getPassword().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getPassword, userTablePojo.getPassword());
        }
        if (userTablePojo.getPym() != null && !userTablePojo.getPym().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getPym, userTablePojo.getPym());
        }
        if (userTablePojo.getSort() != null && !userTablePojo.getSort().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getSort, userTablePojo.getSort());
        }
        if (userTablePojo.getDelFlag() != null && !userTablePojo.getDelFlag().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getDelFlag, userTablePojo.getDelFlag());
        }
        if (userTablePojo.getCreateUser() != null && !userTablePojo.getCreateUser().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getCreateUser, userTablePojo.getCreateUser());
        }
        if (userTablePojo.getUpdateUser() != null && !userTablePojo.getUpdateUser().isEmpty()) {
            userTableLambdaQueryWrapper.eq(UserTablePojo::getUpdateUser, userTablePojo.getUpdateUser());
        }
        return userTableLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param userTablePojo 实体
     * @param type          操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String userTableVerifyS(UserTablePojo userTablePojo, SysEnum type) {
        if ((userTablePojo.getId() == null || userTablePojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return " 主键 ID为空";
        }
        if (userTablePojo.getUserName() == null || userTablePojo.getUserName().isEmpty()) {
            return " 用户名 为空";
        }
        if (userTablePojo.getPassword() == null || userTablePojo.getPassword().isEmpty()) {
            return " 用户密码 为空";
        }
        if (userTablePojo.getPym() == null || userTablePojo.getPym().isEmpty()) {
            return " 拼音码 / 助记码 为空";
        }
        if (userTablePojo.getSort() == null || userTablePojo.getSort().isEmpty()) {
            return " 排序字段 为空";
        }
        if (userTablePojo.getDelFlag() == null || userTablePojo.getDelFlag().isEmpty()) {
            return " 逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
        if (userTablePojo.getCreateUser() == null || userTablePojo.getCreateUser().isEmpty()) {
            return " 创建人账号 为空";
        }
        if (userTablePojo.getUpdateUser() == null || userTablePojo.getUpdateUser().isEmpty()) {
            return " 最后更新人账号 为空";
        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    public Result<?> addUserTable(UserTablePojo userTablePojo) {
        return serviceUtils.insert(userTableMapper, userTablePojo, userTableVerifyS(userTablePojo, SysEnum.SAVE), userTableLambdaQueryWrapper(userTablePojo));
    }


    //删除
    public Result<?> deleteUserTable(UserTablePojo userTablePojo) {
        return serviceUtils.delete(userTableMapper, userTablePojo, userTableVerifyS(userTablePojo, SysEnum.DELETE));
    }

    //修改
    public Result<?> updateUserTable(UserTablePojo userTablePojo) {
        return serviceUtils.update(userTableMapper, userTablePojo, userTableVerifyS(userTablePojo, SysEnum.UPDATE));
    }

    //查询
    public Result<List<UserTablePojo>> getUserTableList(UserTablePojo userTablePojo) {
        return serviceUtils.selectList(userTableMapper, userTableLambdaQueryWrapper(userTablePojo));
    }

    //分页查询
    public Result<Page<UserTablePojo>> getUserTableListPage(UserTablePojo userTablePojo) {
        return serviceUtils.selectPage(userTableMapper, UserTablePojo.class, userTablePojo, userTableLambdaQueryWrapper(userTablePojo));
    }
}