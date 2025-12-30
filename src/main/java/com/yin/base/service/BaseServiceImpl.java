package com.yin.base.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yin.base.entity.Entity;
import com.yin.base.utils.PageUtils;
import com.yin.common.Result;
import com.yin.common.error.ExceptionEnum;

import java.util.List;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    /**
     * 数据新增
     *
     * @param entity  传入的实体类数据
     * @param message 参数判断
     * @return 返回
     */
    protected Result<?> insert(T entity, String message) {
        return getStringResultInsert(entity, message);
    }

    /**
     * 数据新增, 条件参数判断，禁止重复提交新增
     *
     * @param o            传入的实体类数据
     * @param message      参数判断
     * @param queryWrapper 条件参数
     * @return 返回
     */
    public Result<String> insert(T o, String message, LambdaQueryWrapper<T> queryWrapper) {
        List<T> dataS = baseMapper.selectList(queryWrapper);
        if (!dataS.isEmpty()) {
            return Result.error(ExceptionEnum.CODE_A_EXISTS, "");
        }
        return getStringResultInsert(o, message);
    }

    /**
     * 更新
     *
     * @param data    传入的实体类数据
     * @param message 参数判断
     * @return 返回
     */
    public Result<T> update(T data, String message) {
        if (message.equals(ExceptionEnum.CODE_CZ.getResultCode())) {

            boolean b = this.updateById(data);
            if (b) {
                return Result.okUpdate(data);
            } else {
                return Result.errUpdate(data);
            }
        }
        return Result.error(message, data);
    }

    /**
     * 更新根据条件修改
     */
    public Result<T> update(T data, String message, LambdaQueryWrapper<T> queryWrapper) {
        if (message.equals(ExceptionEnum.CODE_CZ.getResultCode())) {
            List<T> list = this.list(queryWrapper);
            boolean b = this.update(list.get(0), queryWrapper);
            if (b) {
                return Result.okUpdate(data);
            } else {
                return Result.errUpdate(data);
            }
        }
        return Result.error(message, data);
    }

    /**
     * 根据id删除
     *
     * @param data    传入的实体类数据
     * @param message 参数判断
     * @return 返回
     */
    public Result<T> delete(T data, String message) {
        if (message.equals(ExceptionEnum.CODE_CZ.getResultCode())) {
            boolean b = this.removeById(data);
            if (b) {
                return Result.okDelete(data);
            } else {
                return Result.errDelete(data);
            }
        }
        return Result.error(message, data);
    }

    /**
     * 删除根据条件
     */
    public Result<T> delete(T data, String message, LambdaQueryWrapper<T> queryWrapper) {
        if (message.equals(ExceptionEnum.CODE_CZ.getResultCode())) {
            List<T> list = this.list(queryWrapper);
            if (list.isEmpty()) {
                return Result.ok(ExceptionEnum.CODE_DELETE_EMPTY, data);
            }
            boolean b = this.remove(queryWrapper);
            if (b) {
                return Result.okDelete(data);
            } else {
                return Result.errDelete(data);
            }
        }
        return Result.error(message, data);
    }

    /**
     * 查询
     *
     * @param queryWrapper 条件
     * @return 返回
     */
    public Result<List<T>> selectFORList(LambdaQueryWrapper<T> queryWrapper) {
        List<T> list = this.list(queryWrapper);
        return Result.okSel(list);
    }

    /**
     * 分页查询
     *
     * @param queryWrapper 条件
     * @return 返回
     */
    public Result<Page<T>> selectPage(T entity, LambdaQueryWrapper<T> queryWrapper) {
        //转换为page类
        Page<T> dictPaidItemDictionaryPojoPage = PageUtils.convertPage((Entity) entity);
        if (dictPaidItemDictionaryPojoPage == null) {
            return Result.error(ExceptionEnum.CODE_VERIFY_PAGE, null);
        }
        //分页查询
        Page<T> pojoPage = this.page(dictPaidItemDictionaryPojoPage, queryWrapper);
        return Result.okSel(pojoPage);
    }

    private Result<String> getStringResultInsert(T data, String message) {
        if (message.equals(ExceptionEnum.CODE_CZ.getResultCode())) {
            boolean save = this.save(data);
            if (save) {
                return Result.okInsert("");
            } else {
                return Result.errInsert("");
            }
        }
        return Result.error(message, "");
    }
}
