package com.ntanougat.rainbow.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.adapter.MyStorysAdapter;
import com.ntanougat.rainbow.base.BaseFragment;
import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.MyStorysBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.presenter.UserPagePresenter;
import com.ntanougat.rainbow.ui.activity.StoryReadActivity;
import com.ntanougat.rainbow.ui.view.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageFragment extends BaseFragment<UserPageContract.View<MyStorysBean.ArrayBean>, UserPagePresenter> implements UserPageContract.View<MyStorysBean.ArrayBean> {

    private static final String TAG = UserPageFragment.class.getSimpleName();

    @BindView(R.id.civ_userhead)
    CircleImageView civ_userhead;
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.iv_editusername)
    ImageView iv_editusername;
    @BindView(R.id.list_mystorys)
    RecyclerView list_mystorys;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private String param;
    private String userId="131";

    public UserPageFragment() {

    }

    public static UserPageFragment newInstance(String param) {
        UserPageFragment userPageFragment = new UserPageFragment();
        Bundle args = new Bundle();
        args.putString("param", param);
        userPageFragment.setArguments(args);
        return userPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            param = getArguments().getString("param");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected UserPagePresenter createPresenter() {
        return new UserPagePresenter(param, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_userpage, container, false);
        ButterKnife.bind(this, v);
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

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.requestRefreshMyStorys(userId);
            }
        });

        iv_editusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.requestChangeUserName();
            }
        });

        civ_userhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(BGAPhotoPickerActivity.newIntent(getActivity(), null, 1, null, false), 55);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 55) {
            final String localPicturePath = BGAPhotoPickerActivity.getSelectedImages(data).get(0);
            mPresenter.requsetChangeUserPortrait(localPicturePath);
        }
    }

    @Override
    public void refreshMyStorys(final List<MyStorysBean.ArrayBean> arrayList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        list_mystorys.setLayoutManager(linearLayoutManager);
        MyStorysAdapter myStorysAdapter = new MyStorysAdapter(arrayList, getActivity());
        myStorysAdapter.SetOnItemClickListener(new MyStorysAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getContext(), StoryReadActivity.class);
                intent.putExtra("storyId",arrayList.get(position).getP_id());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                mPresenter.requsetDeleteOneStory();
            }
        });
        list_mystorys.setAdapter(myStorysAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void changeUserName(String userName) {
        tv_username.setText(userName);
    }

    @Override
    public void changeUserPortrait(String headUrl) {
        Picasso.with(getActivity())
                .load("http://118.89.50.109:8080"+headUrl)
                .error(R.drawable.nopic)
                .into(civ_userhead);
    }

    @Override
    public void deleteOneStory() {
        mPresenter.requestRefreshMyStorys(userId);
    }


}
