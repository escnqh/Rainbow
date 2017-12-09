package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.IsLoginBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Peelson on 2017/12/10.
 */

public interface LoginService {

    @POST("login")
    Call<IsLoginBean> getState(
            @Query("uphone") String userPhone,
            @Query("upsw") String userPassword
    );
}
