package com.ntanougat.rainbow.ui.activity;

import android.os.Bundle;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.base.BaseActivity;
import com.ntanougat.rainbow.base.BasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
