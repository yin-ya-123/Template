package com.yin.base.utils.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 日期具体实现
 */
@Slf4j
public final class HttpLogger {

    private HttpLogger() {}

    public static void logRequest(Request request, String body) {
        if (!HttpLogConfig.ENABLE) return;

        log.info("====== HTTP 请求 ======");
        log.info("方法: {}", request.method());
        log.info("URL: {}", request.url());
        log.info("请求头: {}", request.headers().toMultimap());

        if (HttpLogConfig.LOG_REQUEST_BODY && body != null) {
            log.info("参数信息: {}", cut(body));
        }
    }

    public static void logResponse(Response response, String raw) {
        if (!HttpLogConfig.ENABLE) return;

        log.info("====== HTTP 响应 ======");
        log.info("状态: {}", response.code());
        log.info("URL: {}", response.request().url());

        if (HttpLogConfig.LOG_BODY && raw != null) {
            log.info("响应数据: {}", cut(raw));
        }
    }

    public static void logParsed(Object obj) {
        if (!HttpLogConfig.ENABLE || obj == null) return;
        log.info("Parsed : {}", cut(JsonUtil.toJson(obj)));
    }

    private static String cut(String str) {
        if (str.length() <= HttpLogConfig.MAX_BODY_LENGTH) {
            return str;
        }
        return str.substring(0, HttpLogConfig.MAX_BODY_LENGTH) + "...(truncated)";
    }
    public static void logTimeout(Request request, long start, Exception e) {
        if (!HttpLogConfig.ENABLE) return;

        long cost = System.currentTimeMillis() - start;

        log.warn("====== HTTP 请求超时 ======");
        log.warn("方法: {}", request.method());
        log.warn("URL: {}", request.url());
        log.warn("耗时: {} ms", cost);
        log.warn("错误信息: {}", e.toString());
    }
    public static void logConnectFail(Request request, long start, Exception e) {
        if (!HttpLogConfig.ENABLE) return;

        long cost = System.currentTimeMillis() - start;

        log.error("====== HTTP 服务不可达 ======");
        log.error("方法: {}", request.method());
        log.error("URL: {}", request.url());
        log.error("耗时: {} ms", cost);
        log.error("异常: {}", e.toString());
    }

    public static void logError(Request request, long start, Exception e) {
        if (!HttpLogConfig.ENABLE) return;

        long cost = System.currentTimeMillis() - start;

        log.error("====== HTTP 异常 ======");
        log.error("方法: {}", request.method());
        log.error("URL: {}", request.url());
        log.error("耗时: {} ms", cost);
        log.error("异常: ", e);
    }
    public static void logCost(Request request, long start) {
        if (!HttpLogConfig.ENABLE) return;

        long cost = System.currentTimeMillis() - start;
        log.info("HTTP 耗时: {} ms | {}", cost, request.url());
    }

}
