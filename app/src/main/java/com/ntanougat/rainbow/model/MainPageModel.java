package com.ntanougat.rainbow.model;

import android.util.Log;

import com.ntanougat.rainbow.WebService.GetRotationPicService;
import com.ntanougat.rainbow.WebService.RecommendedStoryService;
import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.MainListStoryBean;
import com.ntanougat.rainbow.entities.RotationPicBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.webApi.GetRotationPicApi;
import com.ntanougat.rainbow.webApi.RecommendStoryApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPageModel implements MainPageContract.Model {

    private MainPageContract.InteractionListener<List<MainListStoryBean.StoryBean>,List<RotationPicBean.StoryBean>> mListener;

    private String param;

    public MainPageModel(String param,MainPageContract.InteractionListener<List<MainListStoryBean.StoryBean>,List<RotationPicBean.StoryBean>> listener){
        this.param=param;
        this.mListener=listener;
    }

    @Override
    public void loadCircleList() {
        GetRotationPicApi getRotationPicApi=new GetRotationPicApi();
        GetRotationPicService getRotationPicService=getRotationPicApi.getService();
        Call<RotationPicBean> call_circle=getRotationPicService.getState();
        call_circle.enqueue(new Callback<RotationPicBean>() {
            @Override
            public void onResponse(Call<RotationPicBean> call, Response<RotationPicBean> response) {
                if (response.body()!=null){
                    mListener.onCircleListLoadSeccess(response.body().getStory());
                    Log.i("circle load seccess","CCCCCCCCCCC");
                }
            }

            @Override
            public void onFailure(Call<RotationPicBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadMainList() {
        RecommendStoryApi recommendStoryApi=new RecommendStoryApi();
        RecommendedStoryService recommendedStoryService=recommendStoryApi.getService();
        Call<MainListStoryBean> call_mainList=recommendedStoryService.getState();
        call_mainList.enqueue(new Callback<MainListStoryBean>() {
            @Override
            public void onResponse(Call<MainListStoryBean> call, Response<MainListStoryBean> response) {
                if (response.body()!=null){
                    mListener.onMainListLoadSeccess(response.body().getStory());
                    Log.i("MianList load seccess","MMMMMM");
                }
            }

            @Override
            public void onFailure(Call<MainListStoryBean> call, Throwable t) {

            }
        });
    }
}
