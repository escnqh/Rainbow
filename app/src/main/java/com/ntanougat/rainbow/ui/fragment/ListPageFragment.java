package com.ntanougat.rainbow.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.adapter.MyStorysAdapter;
import com.ntanougat.rainbow.adapter.SearchResultAdapter;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.ListPagePresenter;
import com.ntanougat.rainbow.ui.activity.StoryReadActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Peelson on 2017/12/9.
 */

public class ListPageFragment extends BaseFragment<ListPageContract.View<DownLoadStoryBean>, ListPagePresenter> implements ListPageContract.View<DownLoadStoryBean>, ListPageContract.Presenter {
    private static final String TAG = ListPageFragment.class.getSimpleName();
    private String param;

    @BindView(R.id.searchresult)
    RecyclerView searchResult;
    @BindView(R.id.ll_search)
    LinearLayout ll_search;


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
    public void showResultList(final List<DownLoadStoryBean> arrayList) {
        ll_search.setVisibility(View.GONE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        searchResult.setLayoutManager(linearLayoutManager);
        SearchResultAdapter searchResultAdapter=new SearchResultAdapter(arrayList,getActivity());
        searchResultAdapter.SetOnItemClickListener(new SearchResultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getContext(), StoryReadActivity.class);
                intent.putExtra("storyId",arrayList.get(position).getP_id());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        searchResult.setAdapter(searchResultAdapter);
    }



    @Override
    protected ListPagePresenter createPresenter() {
        return new ListPagePresenter(param,this);
    }

    @Override
    public void requstShowResult(String text) {
        mPresenter.requstShowResult(text);
    }
}
