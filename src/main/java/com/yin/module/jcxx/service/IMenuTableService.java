package com.yin.module.jcxx.service;

import com.yin.module.jcxx.entity.MenuTablePojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.common.Result;
import java.util.List;
/**
 *  菜单表  服务接口
 */
public interface IMenuTableService extends IService<MenuTablePojo> {
    //新增
    public Result<?> addMenuTable(MenuTablePojo menuTablePojo);

    //删除
    public Result<?> deleteMenuTable(MenuTablePojo menuTablePojo);

    //修改
    public Result<?> updateMenuTable(MenuTablePojo menuTablePojo) ;

    //查询
    public Result<List<MenuTablePojo>> getMenuTableList(MenuTablePojo menuTablePojo);

    //分页查询
    public Result<Page<MenuTablePojo>> getMenuTableListPage(MenuTablePojo menuTablePojo);
    //获取树节点菜单
    public List<MenuTablePojo> getMenuTableTree(MenuTablePojo menuTablePojo);
}