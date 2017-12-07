package com.ntanougat.rainbow.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Peelson on 2017/11/29.
 */

public abstract class BaseActivity<V, P extends BasePresenter<V>>  extends AppCompatActivity{
    protected P mPresenter;
    private static final String TAG = "BaseActivity";
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract P createPresenter();
}
