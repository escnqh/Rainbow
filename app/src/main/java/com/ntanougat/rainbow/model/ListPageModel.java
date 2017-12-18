package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.WebService.DownLoadStoryService;
import com.ntanougat.rainbow.WebService.SearchStorysService;
import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.SearchResultBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.webApi.DownLoadStoryApi;
import com.ntanougat.rainbow.webApi.SearchStoryApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPageModel implements ListPageContract.Model {

    private List<DownLoadStoryBean> storyBeans=new ArrayList<>();
    private ListPageContract.InteractionListener<List<DownLoadStoryBean>> mListener;
    private String param;

    public ListPageModel(String param, ListPageContract.InteractionListener<List<DownLoadStoryBean>> listener) {
        this.param = param;
        this.mListener = listener;
    }

    @Override
    public void loadSearchResult(String text) {
        storyBeans.clear();
        SearchStoryApi searchStoryApi=new SearchStoryApi();
        SearchStorysService searchStorysService=searchStoryApi.getService();
        Call<SearchResultBean> call_search=searchStorysService.getState(text);
        call_search.enqueue(new Callback<SearchResultBean>() {
            @Override
            public void onResponse(Call<SearchResultBean> call, Response<SearchResultBean> response) {
                if(response.body().getStory().size()!=0){
                    for (int i=0;i<response.body().getStory().size();i++){
                        download(response.body().getStory().get(i).getP_id());
//                        if (i==response.body().getArray().size()&&storyBeans.size()!=0){

//                        }
                    }
                    mListener.onInteractionSeccess(storyBeans);
                }
            }

            @Override
            public void onFailure(Call<SearchResultBean> call, Throwable t) {

            }
        });
    }

    private void download(String p_id) {
        DownLoadStoryApi downLoadStoryApi= new DownLoadStoryApi();
        DownLoadStoryService downLoadStoryService=downLoadStoryApi.getService();
        Call<DownLoadStoryBean> call_download=downLoadStoryService.getState(p_id);
        call_download.enqueue(new Callback<DownLoadStoryBean>() {
            @Override
            public void onResponse(Call<DownLoadStoryBean> call, Response<DownLoadStoryBean> response) {
                if(response.body()!=null){
                    storyBeans.add(response.body());
                }
            }

            @Override
            public void onFailure(Call<DownLoadStoryBean> call, Throwable t) {

            }
        });

    }

}
