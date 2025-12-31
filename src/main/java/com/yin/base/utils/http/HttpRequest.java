package com.yin.base.utils.http;

import com.yin.common.error.HttpConnectException;
import com.yin.common.error.HttpTimeoutException;
import okhttp3.*;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 具体实现
 */
public class HttpRequest {

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    enum Method {GET, POST}

    private final String url;
    private Method method;

    private Object data;
    private boolean forceJson;

    private final Map<String, String> headers = new HashMap<>();

    HttpRequest(String url) {
        this.url = url;
    }

    HttpRequest method(Method method) {
        this.method = method;
        return this;
    }

    public HttpRequest header(String k, String v) {
        headers.put(k, v);
        return this;
    }

    public HttpRequest headers(Map<String, String> map) {
        if (map != null) headers.putAll(map);
        return this;
    }

    /**
     * GET / POST 统一入口
     */
    public HttpRequest data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 强制 JSON（POST）
     */
    public HttpRequest json() {
        this.forceJson = true;
        return this;
    }

    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;

    public HttpRequest timeout(int connect, int read, int write) {
        this.connectTimeout = connect;
        this.readTimeout = read;
        this.writeTimeout = write;
        return this;
    }


    public String execute() throws IOException {
        Request request = buildRequest();
        String requestBodyLog = buildRequestBodyLog();

        HttpLogger.logRequest(request, requestBodyLog);

        long start = System.currentTimeMillis();
        OkHttpClient client = HttpClientHolder.get();
        if (connectTimeout != null || readTimeout != null || writeTimeout != null) {
            OkHttpClient.Builder builder = client.newBuilder();

            if (connectTimeout != null) {
                builder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
            }
            if (readTimeout != null) {
                builder.readTimeout(readTimeout, TimeUnit.SECONDS);
            }
            if (writeTimeout != null) {
                builder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
            }
            client = builder.build();
        }
        try (Response response = client
                .newCall(request)
                .execute()) {

            String raw = response.body().string();

            HttpLogger.logResponse(response, raw);
            HttpLogger.logCost(request, start);

            if (!response.isSuccessful()) {
                throw new IOException("HTTP " + response.code());
            }
            return raw;

        } catch (SocketTimeoutException e) {

            HttpLogger.logTimeout(request, start, e);
            throw new HttpTimeoutException("HTTP 请求超时!", e);

        } catch (ConnectException e) {

            // 🚫 连接失败（重点）
            HttpLogger.logConnectFail(request, start, e);
            throw new HttpConnectException("HTTP 服务不可达!", e);

        } catch (IOException e) {

            HttpLogger.logError(request, start, e);
            throw e;
        }
    }


    private Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        headers.forEach(builder::addHeader);

        if (method == Method.GET) {
            builder.url(buildGetUrl()).get();
        } else {
            builder.url(url).post(buildPostBody());
        }
        return builder.build();
    }

    private HttpUrl buildGetUrl() {
        HttpUrl.Builder ub = HttpUrl.parse(url).newBuilder();
        ConvertUtil.toFlatMap(data)
                .forEach((k, v) -> ub.addQueryParameter(k, String.valueOf(v)));
        return ub.build();
    }

    private RequestBody buildPostBody() {
        if (data == null) {
            return RequestBody.create(new byte[0]);
        }

        if (!forceJson && data instanceof Map) {
            FormBody.Builder form = new FormBody.Builder();
            ((Map<?, ?>) data).forEach(
                    (k, v) -> form.add(String.valueOf(k), String.valueOf(v))
            );
            return form.build();
        }

        String json = JsonUtil.toJson(data);
        return RequestBody.create(json, JSON);
    }

    private String buildRequestBodyLog() {
        if (data == null) return null;

        // GET 参数已经在 URL
        if (method == Method.GET) return null;

        if (!forceJson && data instanceof Map) {
            return JsonUtil.toJson(data);
        }
        return JsonUtil.toJson(data);
    }

}
