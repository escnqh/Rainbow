package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.MainPageModel;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPagePresenter extends BasePresenter<MainPageContract.View<Story>> implements MainPageContract.InteractionListener,MainPageContract.Presenter{

    private MainPageContract.View<Story> mView;
    private MainPageContract.Model mModel;
    private String param;
    private ArrayList<Story> mList;


    public MainPagePresenter(String param,MainPageContract.View<Story> view){
        this.param=param;
        this.mView=view;
        mModel=new MainPageModel(param,this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onInteractionSeccess(Object o) {

    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void requstRefreshAll() {

    }
}
