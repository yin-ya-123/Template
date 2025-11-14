package com.yin.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.entity.parent.Entity;

/**
 * 分页帮助类
 */
public class PageUtils {

    /**
     * 判断分页参数是否合法
     *
     * @param Entity
     * @return
     */
    public static boolean pageFlag(Entity Entity) {
        if (Entity == null) {
            return false;
        }
        if (Entity.getPageNumber() != null && Entity.getPageSize() != null) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> Page<T> convertPage(Entity Entity,Class<T> tClass) {
        if (pageFlag(Entity)) {
            return new Page<>(Entity.getPageNumber(), Entity.getPageSize(), tClass.getModifiers());
        }
        return null;
    }
    /**
     * 判断分页参数是否合法
     *
     * @param Entity
     * @return
     */
    public static <T> Page<T> pageFlag(Entity Entity,Class<T> tClass) {
        boolean b = pageFlag(Entity);
        if (b) {
            return new Page<>(Entity.getPageNumber(), Entity.getPageSize(), tClass.getModifiers());
        }
        return null;
    }

}
