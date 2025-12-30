package com.yin.base.utils.http;

public final class Http {

    private Http() {}

    public static HttpRequest get(String url) {
        return new HttpRequest(url).method(HttpRequest.Method.GET);
    }

    public static HttpRequest post(String url) {
        return new HttpRequest(url).method(HttpRequest.Method.POST);
    }
}
