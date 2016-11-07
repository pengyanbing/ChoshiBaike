package com.example.administrator.choshibaike.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class Okhttpclient {
    public static String SVIPURL = "http://m2.qiushibaike.com/article/list/text?page=1&type=refresh&count=30&readarticles=[117874191,274921,117874361]&rqcnt=21&r=53022f631477961991399";
    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();

    public static OkHttpClient getClient() {
        return client;
    }
}
