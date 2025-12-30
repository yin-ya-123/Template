package com.yin.base.utils;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public static String getUUID(int length) {
        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        if (replace.length() < length) {
            return replace;
        }
        return replace.substring(0, length);
    }
}
