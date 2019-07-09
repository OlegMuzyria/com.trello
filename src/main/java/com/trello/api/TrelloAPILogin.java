package com.trello.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.api.CookieStorage;
import com.trello.ui.core.BrowserFactory;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TrelloAPILogin extends BrowserFactory {
    CookieStorage cookieStorage = new CookieStorage();

    OkHttpClient client = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
    Gson gson = new Gson();

    public void loginByAPI () throws IOException, InterruptedException{

        //trello.com
        client.newCall(new Request.Builder().url("https://trello.com").build()).execute().body().string();

        //authentication
        FormBody formData = new FormBody.Builder()
                .add("method", "password")
                .add("factors[user]", "olegmuzyria89@gmail.com")
                .add("factors[password]", "Maxmotives95")
                .build();

        Request request = new Request.Builder().url("https://trello.com/1/authentication").post(formData).build();

        String response = client.newCall(request).execute().body().string();
        Map<String, String > map = gson.fromJson(response, new TypeToken<Map<String, String>>(){}.getType());
        String code = map.get("code");

        //authentication/session

        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody sessionFormData = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession = new Request.Builder().url("https://trello.com/1/authorization/session").post(sessionFormData).build();
        response = client.newCall(requestSession).execute().body().string();

        //selenium
        driver().get("https://trello.com");

        for(Cookie cookie : cookieStorage.cookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.name(),cookie.value());
            driver().manage().addCookie(seleniumCookie);
        }
    }
}
