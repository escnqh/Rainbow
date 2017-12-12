package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.MyStorysBean;
import com.ntanougat.rainbow.entities.UserInfo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Peelson on 2017/12/12.
 */

public interface GetStroysService {
    @POST("getWorks")
    Call<MyStorysBean> getState(
            @Query("uid") String userId
    );
}
