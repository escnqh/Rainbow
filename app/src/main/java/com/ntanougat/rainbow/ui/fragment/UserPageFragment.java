package com.ntanougat.rainbow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.UserPagePresenter;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageFragment extends BaseFragment<UserPageContract.View<Story>,UserPagePresenter> implements UserPageContract.View<Story>{

    private static final String TAG=UserPageFragment.class.getSimpleName();

    private String param;

    public UserPageFragment(){

    }

    public static UserPageFragment newInstance(String param){
        UserPageFragment userPageFragment=new UserPageFragment();
        Bundle args=new Bundle();
        args.putString("param",param);
        userPageFragment.setArguments(args);
        return userPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if(getArguments()!=null){
            param=getArguments().getString("param");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected UserPagePresenter createPresenter() {
        return new UserPagePresenter(param,this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_userpage,container,false);
        initView(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mPresenter.start();
    }

    private void initView(View v) {

    }

    @Override
    public void refreshMyStorys(ArrayList<Story> arrayList) {

    }

    @Override
    public void changeUserName() {

    }

    @Override
    public void changeUserPortrait() {

    }

    @Override
    public void deleteOneStory() {

    }


}
