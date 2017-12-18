package com.ntanougat.rainbow.model;

import android.util.Log;
import android.widget.Toast;

import com.ntanougat.rainbow.WebService.DownLoadStoryService;
import com.ntanougat.rainbow.contract.StoryReadContract;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.webApi.DownLoadStoryApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/11.
 */

public class StoryReadModel implements StoryReadContract.Model {

    private StoryReadContract.InteractionListener<DownLoadStoryBean> mListener;

    private String param;

    public StoryReadModel(String param,StoryReadContract.InteractionListener<DownLoadStoryBean> mListenner){
        this.param=param;
        this.mListener=mListenner;
    }

    @Override
    public void loadStory(final String storyId) {
        DownLoadStoryApi downLoadStoryApi=new DownLoadStoryApi();
        DownLoadStoryService downLoadStoryService=downLoadStoryApi.getService();
        Call<DownLoadStoryBean>call_download=downLoadStoryService.getState(storyId);
        call_download.enqueue(new Callback<DownLoadStoryBean>() {
            @Override
            public void onResponse(Call<DownLoadStoryBean> call, Response<DownLoadStoryBean> response) {
                if(response.body()!=null){
                    Log.i("downloadSeccess","  "+storyId);
                    mListener.onLoadStorySeccess(response.body());
                }
                Log.i("downloadFailed","  "+storyId);
            }

            @Override
            public void onFailure(Call<DownLoadStoryBean> call, Throwable t) {
                Log.i("downloadFailed","  "+storyId);
            }
        });
    }
}
