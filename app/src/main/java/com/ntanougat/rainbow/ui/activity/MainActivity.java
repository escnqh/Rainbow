package com.ntanougat.rainbow.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.adapter.CardFragmentPagerAdapter;
import com.ntanougat.rainbow.adapter.CardPagerAdapter;
import com.ntanougat.rainbow.entities.CardItem;
import com.ntanougat.rainbow.utils.ShadowTransformer;


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private CardPagerAdapter mCardAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("1", "123"));
        mCardAdapter.addCardItem(new CardItem("2", "123"));
        mCardAdapter.addCardItem(new CardItem("3", "123"));


        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);


    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

//    @Override
//    protected BasePresenter createPresenter() {
//        return null;
//    }
}
