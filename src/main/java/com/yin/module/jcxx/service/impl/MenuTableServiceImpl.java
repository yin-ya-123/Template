package com.yin.module.jcxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.base.service.BaseServiceImpl;
import com.yin.common.Result;
import com.yin.common.error.ExceptionEnum;
import com.yin.common.sys.SysEnum;
import com.yin.module.jcxx.entity.MenuTablePojo;
import com.yin.module.jcxx.mapper.MenuTableMapper;
import com.yin.module.jcxx.service.IMenuTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 菜单表  服务实现类
 */
@Service
public class MenuTableServiceImpl extends BaseServiceImpl<MenuTableMapper, MenuTablePojo> implements IMenuTableService {
    @Autowired
    private MenuTableMapper baseMapper;

    /**
     * 常用查询条件
     *
     * @param menuTablePojo
     */
    public LambdaQueryWrapper<MenuTablePojo> menuTableLambdaQueryWrapper(MenuTablePojo menuTablePojo) {
        LambdaQueryWrapper<MenuTablePojo> menuTableLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (menuTablePojo.getId() != null && !menuTablePojo.getId().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getId, menuTablePojo.getId());
        }
        if (menuTablePojo.getMenuName() != null && !menuTablePojo.getMenuName().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getMenuName, menuTablePojo.getMenuName());
        }
        if (menuTablePojo.getMenuUrl() != null && !menuTablePojo.getMenuUrl().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getMenuUrl, menuTablePojo.getMenuUrl());
        }
        if (menuTablePojo.getParentId() != null && !menuTablePojo.getParentId().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getParentId, menuTablePojo.getParentId());
        }
        if (menuTablePojo.getMenuType() != null && !menuTablePojo.getMenuType().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getMenuType, menuTablePojo.getMenuType());
        }
        if (menuTablePojo.getPym() != null && !menuTablePojo.getPym().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getPym, menuTablePojo.getPym());
        }
        if (menuTablePojo.getSort() != null && !menuTablePojo.getSort().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getSort, menuTablePojo.getSort());
        }
        if (menuTablePojo.getDelFlag() != null && !menuTablePojo.getDelFlag().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getDelFlag, menuTablePojo.getDelFlag());
        }
        if (menuTablePojo.getCreateUser() != null && !menuTablePojo.getCreateUser().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getCreateUser, menuTablePojo.getCreateUser());
        }
        if (menuTablePojo.getUpdateUser() != null && !menuTablePojo.getUpdateUser().isEmpty()) {
            menuTableLambdaQueryWrapper.eq(MenuTablePojo::getUpdateUser, menuTablePojo.getUpdateUser());
        }
        menuTableLambdaQueryWrapper.orderByAsc(MenuTablePojo::getSort);
        return menuTableLambdaQueryWrapper;
    }

    /**
     * 参数校验
     *
     * @param menuTablePojo 实体
     * @param type          操作类型 0 新增 1 删除 2修改
     * @return 标志
     */
    public String menuTableVerifyS(MenuTablePojo menuTablePojo, SysEnum type) {
        if ((menuTablePojo.getId() == null || menuTablePojo.getId().isEmpty()) && (type.getSysCodeInt().equals(SysEnum.DELETE.getSysCodeInt()) || type.getSysCodeInt().equals(SysEnum.UPDATE.getSysCodeInt()))) {
            return " 主键 ID为空";
        }
        if (menuTablePojo.getMenuName() == null || menuTablePojo.getMenuName().isEmpty()) {
            return " 菜单名称 为空";
        }
        if (menuTablePojo.getMenuUrl() == null || menuTablePojo.getMenuUrl().isEmpty()) {
            return " 菜单链接 为空";
        }
        if (menuTablePojo.getParentId() == null || menuTablePojo.getParentId().isEmpty()) {
            return " 父菜单 ID为空";
        }
        if (menuTablePojo.getMenuType() == null || menuTablePojo.getMenuType().isEmpty()) {
            return " 菜单类型 为空";
        }
        if (menuTablePojo.getPym() == null || menuTablePojo.getPym().isEmpty()) {
            return " 拼音码 / 助记码 为空";
        }
        if (menuTablePojo.getSort() == null || menuTablePojo.getSort().isEmpty()) {
            return " 排序字段 为空";
        }
        if (menuTablePojo.getDelFlag() == null || menuTablePojo.getDelFlag().isEmpty()) {
            return " 逻辑删除标志（'0'：未删除，'1'：已删除）为空";
        }
//        if (menuTablePojo.getCreateUser() == null || menuTablePojo.getCreateUser().isEmpty()) {
//            return " 创建人账号 为空";
//        }
//        if (menuTablePojo.getUpdateUser() == null || menuTablePojo.getUpdateUser().isEmpty()) {
//            return " 最后更新人账号 为空";
//        }
        return ExceptionEnum.CODE_CZ.getResultCode();
    }

    //新增
    @Override
    public Result<?> addMenuTable(MenuTablePojo menuTablePojo) {
        return insert(menuTablePojo, menuTableVerifyS(menuTablePojo, SysEnum.SAVE), menuTableLambdaQueryWrapper(menuTablePojo));
    }

    //删除
    @Override
    public Result<?> deleteMenuTable(MenuTablePojo menuTablePojo) {
        //判断是否还有子菜单
        LambdaQueryWrapper<MenuTablePojo> menuTablePojoLambdaQueryWrapper = menuTableLambdaQueryWrapper(new MenuTablePojo());
        menuTablePojoLambdaQueryWrapper.eq(MenuTablePojo::getParentId, menuTablePojo.getId());
        Long count = baseMapper.selectCount(menuTablePojoLambdaQueryWrapper);
        if (count > 0) {
            return Result.error(ExceptionEnum.CODE_DELETE, null);
        } else {
            return delete(menuTablePojo, menuTableVerifyS(menuTablePojo, SysEnum.DELETE));
        }
    }

    //修改
    @Override
    public Result<?> updateMenuTable(MenuTablePojo menuTablePojo) {
        return update(menuTablePojo, menuTableVerifyS(menuTablePojo, SysEnum.UPDATE));
    }

    //查询
    @Override
    public Result<List<MenuTablePojo>> getMenuTableList(MenuTablePojo menuTablePojo) {
        return selectFORList(menuTableLambdaQueryWrapper(menuTablePojo));
    }

    //分页查询
    @Override
    public Result<Page<MenuTablePojo>> getMenuTableListPage(MenuTablePojo menuTablePojo) {
        return selectPage(menuTablePojo, menuTableLambdaQueryWrapper(menuTablePojo));
    }

    @Override
    public List<MenuTablePojo> getMenuTableTree(MenuTablePojo menuTablePojo) {
        // 一次性查出所有的菜单项
        List<MenuTablePojo> allMenus = baseMapper.selectList(menuTableLambdaQueryWrapper(menuTablePojo));
        return getMenuTableTree(allMenus);
    }

    @Override
    public List<MenuTablePojo> getMenuTreeS(String userId) {
        List<MenuTablePojo> menuTreeS = baseMapper.getMenuTreeS(userId);
        return getMenuTableTree(menuTreeS);

    }

    /**
     * 根据 List<MenuTablePojo> 组装数据
     */
    public List<MenuTablePojo> getMenuTableTree(List<MenuTablePojo> allMenus) {
        // 构建ID到菜单的映射，方便快速查找
        Map<String, MenuTablePojo> menuMap = allMenus.stream()
                .collect(Collectors.toMap(MenuTablePojo::getId, Function.identity()));

        // 存储最终结果（顶级节点）
        List<MenuTablePojo> rootMenus = new ArrayList<>();

        for (MenuTablePojo menu : allMenus) {
            String parentId = menu.getParentId();
            if ("0".equals(parentId)) {
                // 如果是根节点，则加入rootMenus
                rootMenus.add(menu);
            } else {
                // 否则找到父节点并添加为子节点
                MenuTablePojo parentMenu = menuMap.get(parentId);
                if (parentMenu != null) {
                    if (parentMenu.getChildren() == null) {
                        parentMenu.setChildren(new ArrayList<>());
                    }
                    parentMenu.getChildren().add(menu);
                }
            }
        }
        return rootMenus;
    }
}