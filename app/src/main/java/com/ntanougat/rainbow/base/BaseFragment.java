package com.ntanougat.rainbow.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Peelson on 2017/11/25.
 */

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment {
    protected P mPresenter;
    private static final String TAG = "BaseFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract P createPresenter();
}
