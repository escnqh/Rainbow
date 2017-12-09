package com.ntanougat.rainbow.webApi;

import com.ntanougat.rainbow.WebService.LoginService;

import retrofit2.Retrofit;

/**
 * Created by Peelson on 2017/12/10.
 */

public class LoginApi extends WebApi {

    String url="http://118.89.50.109:8080/SEpracticum1/user/";
    Retrofit retrofit=getApi(url);

    @Override
    public <T> T getService() {
        return (T) retrofit.create(LoginService.class);
    }
}
