package com.yin.base.utils.http;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public final class HttpClientHolder {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectionPool(new ConnectionPool(200, 5, TimeUnit.MINUTES))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    private HttpClientHolder() {}

    public static OkHttpClient get() {
        return CLIENT;
    }
}
