package com.yin.base.utils.http;

/**
 * 日期打印控制类
 */
public final class HttpLogConfig {

    /** 是否开启 HTTP 日志 */
    public static boolean ENABLE = true;

    /** 是否打印请求体 / 响应体 */
    public static boolean LOG_BODY = false;
    /*是否打印请求体*/
    public static boolean LOG_REQUEST_BODY = true;
    /** 超过长度自动截断，防止刷屏 */
    public static int MAX_BODY_LENGTH = 5000;

    private HttpLogConfig() {}
}
