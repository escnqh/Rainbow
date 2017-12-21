package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.RotationPicBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Peelson on 2017/12/21.
 */

public interface GetRotationPicService {
    @GET("getRotationPic")
    Call<RotationPicBean> getState();
}
