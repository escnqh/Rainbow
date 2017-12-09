package com.ntanougat.rainbow.webApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Peelson on 2017/12/10.
 */

public abstract class WebApi {

    Retrofit getApi(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public abstract <T> T getService();

}
