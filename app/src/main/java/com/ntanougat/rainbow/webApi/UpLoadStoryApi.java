package com.ntanougat.rainbow.webApi;

import com.ntanougat.rainbow.WebService.UpLoadStoryService;

import retrofit2.Retrofit;

/**
 * Created by Peelson on 2017/12/17.
 */

public class UpLoadStoryApi extends WebApi {

    String url="http://118.89.50.109:8080/SEpracticum1/works/";
    Retrofit retrofit=getApi(url);
    @Override
    public <T> T getService() {
        return (T) retrofit.create(UpLoadStoryService.class);
    }
}
