package com.ntanougat.rainbow.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.adapter.CardFragmentPagerAdapter;
import com.ntanougat.rainbow.adapter.CardPagerAdapter;
import com.ntanougat.rainbow.base.BaseActivity;
import com.ntanougat.rainbow.contract.StoryReadContract;
import com.ntanougat.rainbow.entities.CardItem;
import com.ntanougat.rainbow.entities.Situation;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.StoryReadPresenter;
import com.ntanougat.rainbow.utils.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Peelson on 2017/12/12.
 */

public class StoryReadActivity extends BaseActivity<StoryReadContract.View<Story>, StoryReadPresenter> implements StoryReadContract.View<Story> {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.btn_startExam)
    Button btn_startExam;

    private String param;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_read);
        ButterKnife.bind(this);
        initView();


    }

    private void initView() {
        btn_startExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public void showStory(Story story) {
        List<Situation> situations=story.getSituationBeans();
        mCardAdapter = new CardPagerAdapter();
        for (int i=0;i<=situations.size();i++){
            Situation situation=situations.get(i);
            mCardAdapter.addCardItem(new CardItem(situation.getContent(),situation.getImgUrl()));
        }
        mFragmentCardAdapter=new CardFragmentPagerAdapter(getSupportFragmentManager(),dpToPixels(2,this));
        mCardShadowTransformer=new ShadowTransformer(mViewPager,mCardAdapter);
        mFragmentCardShadowTransformer=new ShadowTransformer(mViewPager,mFragmentCardAdapter);
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    protected StoryReadPresenter createPresenter() {
        return new StoryReadPresenter(param,this);
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
