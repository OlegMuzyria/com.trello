package com.trello.api;

import com.trello.api.interseptors.TrelloAuthInterceptor;
import com.trello.api.services.BoardService;
import com.trello.api.services.CardService;
import com.trello.api.services.ListService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.concurrent.TimeUnit;

public class TrelloRestClient {

    public static final String HOME_IO_BASE_URL = "https://api.trello.com/1/";


    public BoardService boardService;
    public ListService listService;
    public CardService cardService;


    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        boardService = retrofit.create(BoardService.class);
        listService = retrofit.create(ListService.class);
        cardService = retrofit.create(CardService.class);
    }
}
