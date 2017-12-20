package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.IsTureBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 17823 on 2017/12/14.
 */

public interface SignService {

    @POST("register")
    Call<IsTureBean> getState(
            @Query("uphone") String userPhone,
            @Query("uname") String uname,
            @Query("upsw") String userPassword
    );
}