package com.ntanougat.rainbow.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.MainPagePresenter;
import com.ntanougat.rainbow.ui.activity.NewStoryActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Peelson on 2017/12/9.
 */

public class MainPageFragment extends BaseFragment<MainPageContract.View<Story>, MainPagePresenter> implements MainPageContract.View<Story> {

    private String param;

    @BindView(R.id.fbtn_newstory)
    FloatingActionButton floatingActionButton;

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

    @Override
    protected MainPagePresenter createPresenter() {
        return new MainPagePresenter(param, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainpage, container, false);
        ButterKnife.bind(this,v);
        initView(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initView(View v) {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), NewStoryActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initData() {
        mPresenter.start();
    }

    @Override
    public void refreshAll(ArrayList<Story> arrayList) {

    }
}
