package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.ListPageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPagePresenter extends BasePresenter<ListPageContract.View<DownLoadStoryBean>> implements ListPageContract.InteractionListener<List<DownLoadStoryBean>>, ListPageContract.Presenter {

    private ListPageContract.View<DownLoadStoryBean> mView;
    private ListPageContract.Model mModel;
    private String param;
    private List<DownLoadStoryBean> mList;

    public ListPagePresenter(String param, ListPageContract.View<DownLoadStoryBean> mView) {
        this.param = param;
        this.mView = mView;
        mModel = new ListPageModel(param, this);
    }


    @Override
    public void onInteractionSeccess(List<DownLoadStoryBean> stories) {
        mView.showResultList(stories);
    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void start() {

    }

    @Override
    public void requstShowResult(String text) {
        mModel.loadSearchResult(text);
    }
}
