package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.ListPageModel;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPagePresenter extends BasePresenter<ListPageContract.View<Story>> implements ListPageContract.InteractionListener<ArrayList<Story>>, ListPageContract.Presenter {

    private ListPageContract.View<Story> mView;
    private ListPageContract.Model mModel;
    private String param;
    private ArrayList<Story> mList;

    public ListPagePresenter(String param, ListPageContract.View<Story> mView) {
        this.param = param;
        this.mView = mView;
        mModel = new ListPageModel(param, this);
    }

    @Override
    public void requstShowResult() {

    }

    @Override
    public void onInteractionSeccess(ArrayList<Story> stories) {

    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void start() {

    }
}
