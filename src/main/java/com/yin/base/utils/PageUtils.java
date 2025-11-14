package com.yin.base.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yin.base.entity.Entity;

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

    public static <T> Page<T> convertPage(Entity Entity) {
        if (pageFlag(Entity)) {
            return new Page<>(Entity.getPageNumber(), Entity.getPageSize());
        }
        return null;
    }

}
