package com.ntanougat.rainbow.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.ListPagePresenter;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Peelson on 2017/12/9.
 */

public class ListPageFragment extends BaseFragment<ListPageContract.View<Story>, ListPagePresenter> implements ListPageContract.View<Story>, ListPageContract.Presenter {
    private static final String TAG = ListPageFragment.class.getSimpleName();
    private String param;


    public ListPageFragment() {

    }

    public static ListPageFragment newInstance(String param) {
        ListPageFragment listPageFragment = new ListPageFragment();
        Bundle args = new Bundle();
        args.putString("param", param);
        listPageFragment.setArguments(args);
        return listPageFragment;
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
        View v = inflater.inflate(R.layout.fragment_listpage, container, false);
        ButterKnife.bind(this,v);
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
    public void showResultList(ArrayList<Story> arrayList) {

    }



    @Override
    protected ListPagePresenter createPresenter() {
        return new ListPagePresenter(param,this);
    }

    @Override
    public void requstShowResult(String text) {

    }
}
