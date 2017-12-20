package com.ntanougat.rainbow.webApi;

import com.ntanougat.rainbow.WebService.SignService;

import retrofit2.Retrofit;

/**
 * Created by 17823 on 2017/12/14.
 */

public class SignApi extends WebApi {
    String url="http://118.89.50.109:8080/SEpracticum1/user/";
    Retrofit retrofit=getApi(url);

    @Override
    public <T> T getService()  {
        return (T) retrofit.create(SignService.class);
    }
}