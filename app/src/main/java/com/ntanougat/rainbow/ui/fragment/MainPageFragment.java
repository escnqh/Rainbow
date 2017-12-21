package com.ntanougat.rainbow.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.DownLoadStoryService;
import com.ntanougat.rainbow.WebService.GetRotationPicService;
import com.ntanougat.rainbow.WebService.RecommendedStoryService;
import com.ntanougat.rainbow.adapter.SearchResultAdapter;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.MainListStoryBean;
import com.ntanougat.rainbow.entities.RotationPicBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.MainPagePresenter;
import com.ntanougat.rainbow.ui.activity.NewStoryActivity;
import com.ntanougat.rainbow.ui.activity.StoryReadActivity;
import com.ntanougat.rainbow.webApi.DownLoadStoryApi;
import com.ntanougat.rainbow.webApi.GetRotationPicApi;
import com.ntanougat.rainbow.webApi.RecommendStoryApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wangyuwei.banner.BannerEntity;
import me.wangyuwei.banner.BannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/9.
 */

public class MainPageFragment extends Fragment {

    @BindView(R.id.banner_view)
    BannerView mBannerView;
    @BindView(R.id.list_allstorys)
    RecyclerView listAllstorys;
    private String param;

    @BindView(R.id.fbtn_newstory)
    FloatingActionButton floatingActionButton;
    private List<DownLoadStoryBean> storyBeans=new ArrayList<>();

    private List<BannerEntity> bannerEntities = new ArrayList<>();

    public MainPageFragment() {

    }

    public static MainPageFragment newInstance(String param) {
        MainPageFragment mainPageFragment = new MainPageFragment();
        Bundle args = new Bundle();
        args.putString("param", param);
        mainPageFragment.setArguments(args);
        return mainPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            param = getArguments().getString("param");

        }
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainpage, container, false);
        ButterKnife.bind(this, v);
        initView(v);
        initData();
        return v;
    }

    @Override
    public void onStart() {

        super.onStart();
        mBannerView.setAutoScroll(2);
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    private void initData() {
        loadCircleList();
        loadMainList();
    }

    public void loadCircleList() {
        GetRotationPicApi getRotationPicApi = new GetRotationPicApi();
        GetRotationPicService getRotationPicService = getRotationPicApi.getService();
        Call<RotationPicBean> call_circle = getRotationPicService.getState();
        call_circle.enqueue(new Callback<RotationPicBean>() {
            @Override
            public void onResponse(Call<RotationPicBean> call, Response<RotationPicBean> response) {
                if (response.body() != null) {
                    Log.i("circle load seccess", "CCCCCCCCCCC");
                    for (int i = 0; i < response.body().getStory().size(); i++) {
                        BannerEntity bannerEntity = new BannerEntity();
                        bannerEntity.imageUrl ="http://118.89.50.109:8080"+ response.body().getStory().get(i).getRp_url();
                        bannerEntity.title = response.body().getStory().get(i).getRp_title();
                        bannerEntities.add(bannerEntity);
                    }
                    if (bannerEntities.size()!=0)
                    mBannerView.setEntities(bannerEntities);
                }
            }

            @Override
            public void onFailure(Call<RotationPicBean> call, Throwable t) {

            }
        });
    }

    public void loadMainList() {
        RecommendStoryApi recommendStoryApi = new RecommendStoryApi();
        RecommendedStoryService recommendedStoryService = recommendStoryApi.getService();
        Call<MainListStoryBean> call_mainList = recommendedStoryService.getState();
        call_mainList.enqueue(new Callback<MainListStoryBean>() {
            @Override
            public void onResponse(Call<MainListStoryBean> call, Response<MainListStoryBean> response) {
                if (response.body() != null) {
                    Log.i("MianList load seccess", "MMMMMM");
                    for (int i=0;i<response.body().getStory().size();i++){
                        download(response.body().getStory().get(i).getP_id());

                    }
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                            listAllstorys.setLayoutManager(linearLayoutManager);
                            SearchResultAdapter searchResultAdapter=new SearchResultAdapter(storyBeans,getActivity());
                            searchResultAdapter.SetOnItemClickListener(new SearchResultAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Intent intent=new Intent(getContext(), StoryReadActivity.class);
                                    intent.putExtra("storyId",storyBeans.get(position).getP_id());
                                    startActivity(intent);
                                }

                                @Override
                                public void onItemLongClick(View view, int position) {

                                }
                            });
                            listAllstorys.setAdapter(searchResultAdapter);
                        }
                    },1000);
                }
            }

            @Override
            public void onFailure(Call<MainListStoryBean> call, Throwable t) {

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View v) {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NewStoryActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
