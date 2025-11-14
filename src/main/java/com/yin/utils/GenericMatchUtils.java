package com.yin.utils;

import com.yin.common.error.BizException;
import com.yin.common.error.ExceptionEnum;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 通用入参与对象匹配工具类
 * 功能：判断入参的非空字段是否与目标对象的对应字段值一致
 */
public class GenericMatchUtils {

    public static void isMatch(Object param, Object target) {
        boolean matchPrivate = isMatchPrivate(param, target);
        if (matchPrivate) {
            throw new BizException(ExceptionEnum.CODE_VERIFY_ENTITY.getResultMsg());
        }
    }

    /**
     * 通用匹配方法：入参的非空字段必须与目标对象的对应字段值完全一致
     *
     * @param param  入参对象（如DTO、Map、请求参数对象等）
     * @param target 目标对象（如UserTablePojo实例）
     * @return 匹配不成功返回true，否则false（入参或目标为null时返回true）
     */
    private static boolean isMatchPrivate(Object param, Object target) {
        // 非空校验
        if (param == null || target == null) {
            return true;
        }

        // 获取入参的所有非空字段及其值
        Map<String, Object> nonNullParamFields = getNonNullFields(param);
        // 若入参无任何非空字段，默认不匹配（可根据业务调整）
        if (nonNullParamFields.isEmpty()) {
            return true;
        }

        // 获取目标对象的字段访问器
        BeanWrapper targetWrapper = new BeanWrapperImpl(target);

        // 遍历入参的非空字段，与目标对象对比
        for (Map.Entry<String, Object> entry : nonNullParamFields.entrySet()) {
            String fieldName = entry.getKey();
            Object paramValue = entry.getValue();

            // 检查目标对象是否包含该字段
            if (!hasField(targetWrapper, fieldName)) {
                // 入参包含目标对象不存在的字段，不匹配
                return true;
            }

            // 获取目标对象的字段值
            Object targetValue = targetWrapper.getPropertyValue(fieldName);

            // 对比字段值（支持null安全比较）
            if (!Objects.equals(paramValue, targetValue)) {
                return true;
            }
        }

        // 所有非空字段均匹配
        return false;
    }

    /**
     * 获取对象中所有非空字段及其值（key：字段名，value：字段值）
     */
    private static Map<String, Object> getNonNullFields(Object obj) {
        Map<String, Object> nonNullFields = new HashMap<>();
        BeanWrapper wrapper = new BeanWrapperImpl(obj);
        PropertyDescriptor[] descriptors = wrapper.getPropertyDescriptors();

        for (PropertyDescriptor descriptor : descriptors) {
            String fieldName = descriptor.getName();
            // 跳过class字段（所有对象都有的getClass()方法）
            if ("class".equals(fieldName)) {
                continue;
            }
            // 获取字段值
            Object value = wrapper.getPropertyValue(fieldName);
            if (value != null) {
                nonNullFields.put(fieldName, value);
            }
        }
        return nonNullFields;
    }

    /**
     * 检查目标对象是否包含指定字段
     */
    private static boolean hasField(BeanWrapper wrapper, String fieldName) {
        try {
            // 尝试获取字段描述符，不存在则抛异常
            wrapper.getPropertyDescriptor(fieldName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}