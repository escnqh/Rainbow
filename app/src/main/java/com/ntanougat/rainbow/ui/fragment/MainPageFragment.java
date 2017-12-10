package com.ntanougat.rainbow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.base.BasePresenter;

/**
 * Created by Peelson on 2017/12/9.
 */

public class MainPageFragment extends BaseFragment {
    private String param;

    public MainPageFragment(){

    }

    public static MainPageFragment newInstance(String param){
        MainPageFragment mainPageFragment=new MainPageFragment();
        Bundle args=new Bundle();
        args.putString("param",param);
        mainPageFragment.setArguments(args);
        return mainPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if(getArguments()!=null){
            param=getArguments().getString("param");
        }
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
