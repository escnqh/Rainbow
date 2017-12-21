package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.MainListStoryBean;
import com.ntanougat.rainbow.entities.RotationPicBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Peelson on 2017/12/21.
 */

public interface RecommendedStoryService {
    @GET("recommendStory")
    Call<MainListStoryBean> getState();
}
