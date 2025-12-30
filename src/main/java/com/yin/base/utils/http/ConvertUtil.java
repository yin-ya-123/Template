package com.yin.base.utils.http;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ConvertUtil {

    private ConvertUtil() {}

    public static Map<String, Object> toFlatMap(Object obj) {
        if (obj == null) return Collections.emptyMap();

        if (obj instanceof Map) {
            return (Map<String, Object>) obj;
        }

        Map<String, Object> map = new LinkedHashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value != null) {
                    map.put(field.getName(), value);
                }
            } catch (IllegalAccessException ignored) {}
        }
        return map;
    }
}
