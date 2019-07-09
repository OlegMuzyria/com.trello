package com.trello.api.interseptors;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TrelloAuthInterceptor implements Interceptor {

    private static final String KEY = "f758828d6080bab37a614e97f9608a88";
    private static final String TOKEN = "f3e8b4041390cb1762095954518600a67776d52c9b86520b55d5e32cc9ac0216";

    @Override
    public Response intercept (Chain chain) throws IOException{
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
