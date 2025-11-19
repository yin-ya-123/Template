package com.yin.module.jcxx.controller;

import com.yin.common.Result;
import com.yin.module.jcxx.entity.MenuTablePojo;
import com.yin.module.jcxx.service.IMenuTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  菜单表  前端控制器
 */
@RestController
@RequestMapping("/menuTable")
public class MenuTableController {

    @Autowired
    private IMenuTableService menuTableService;
    /*
        新增
    */
    @PostMapping("addMenuTable")
    public Result<?> addMenuTablePojo(@RequestBody MenuTablePojo menuTablePojo) {
    return menuTableService.addMenuTable(menuTablePojo);
    }
    //新增
    @PostMapping("addMenuTableS")
    @Transactional
    public Result<?> addMenuTablePojo(@RequestBody List<MenuTablePojo> menuTablePojos) {
        Result<?> result = null;
        for (MenuTablePojo menuTablePojo : menuTablePojos) {
        result = menuTableService.addMenuTable(menuTablePojo);
        }
        return result;
    }

    //删除
    @PostMapping("deleteMenuTable")
    public Result<?> deleteMenuTablePojo(@RequestBody MenuTablePojo menuTablePojo) {
        return menuTableService.deleteMenuTable(menuTablePojo);
    }

    //修改
    @PostMapping("updateMenuTable")
    public Result<?> updateMenuTablePojo(@RequestBody MenuTablePojo menuTablePojo) {
        return menuTableService.updateMenuTable(menuTablePojo);
    }

    //查询
    @PostMapping("/getMenuTableList")
    public Result<?> getMenuTablePojoList(@RequestBody MenuTablePojo menuTablePojo) {
        return menuTableService.getMenuTableList(menuTablePojo);
    }


    //分页查询
    @PostMapping("getMenuTableListPage")
    public Result<?> getMenuTablePojoListPage(@RequestBody MenuTablePojo menuTablePojo) {
        return menuTableService.getMenuTableListPage(menuTablePojo);
    }

    /**
     * 获取菜单树
     */
    @PostMapping("getMenuTableTree")
    public Result<?> getMenuTableTree(@RequestBody MenuTablePojo menuTablePojo) {
        List<MenuTablePojo> menuTableTree = menuTableService.getMenuTableTree(menuTablePojo);
        return Result.okSel(menuTableTree);
    }
}