package com.ntanougat.rainbow.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.DownLoadStoryService;
import com.ntanougat.rainbow.adapter.CardFragmentPagerAdapter;
import com.ntanougat.rainbow.adapter.CardPagerAdapter;
import com.ntanougat.rainbow.adapter.ExamCardPagerAdapter;
import com.ntanougat.rainbow.base.BaseActivity;
import com.ntanougat.rainbow.contract.ExamContract;
import com.ntanougat.rainbow.entities.CardItem;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.Situation;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.ExamPresenter;
import com.ntanougat.rainbow.utils.ShadowTransformer;
import com.ntanougat.rainbow.webApi.DownLoadStoryApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/13.
 */

public class ExamActivity extends AppCompatActivity{

    @BindView(R.id.viewPager_exam)
    ViewPager mViewPager;
    @BindView(R.id.btn_checkExam)
    Button btn_checkExam;

    private String storyId;

    private ExamCardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        storyId=intent.getStringExtra("storyId");
        loadStory(storyId);
        initView();
    }

    private void initView() {
        btn_checkExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void loadStory(final String storyId) {
        DownLoadStoryApi downLoadStoryApi = new DownLoadStoryApi();
        DownLoadStoryService downLoadStoryService = downLoadStoryApi.getService();
        Call<DownLoadStoryBean> call_download = downLoadStoryService.getState(storyId);
        call_download.enqueue(new Callback<DownLoadStoryBean>() {
            @Override
            public void onResponse(Call<DownLoadStoryBean> call, Response<DownLoadStoryBean> response) {
                if (response.body() != null) {
                    Log.i("downloadSeccess", "  " + storyId);
                    List<DownLoadStoryBean.StoryBean> list=response.body().getStory();
                    Collections.shuffle(list);
                    showStory(list);
                }
                Log.i("downloadFailed", "  " + storyId);
            }

            @Override
            public void onFailure(Call<DownLoadStoryBean> call, Throwable t) {
                Log.i("downloadFailed", "  " + storyId);
            }
        });
    }

    public void showStory(List<DownLoadStoryBean.StoryBean> situations) {
        mCardAdapter = new ExamCardPagerAdapter(this);
        for (int i = 0; i < situations.size(); i++) {
            DownLoadStoryBean.StoryBean situation = situations.get(i);
            mCardAdapter.addCardItem(new CardItem(situation.getG_id(), situation.getPicture_url()));
        }
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
