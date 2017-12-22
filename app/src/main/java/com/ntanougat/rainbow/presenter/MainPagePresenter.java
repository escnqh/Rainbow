package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.MainListStoryBean;
import com.ntanougat.rainbow.entities.RotationPicBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.MainPageModel;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPagePresenter extends BasePresenter<MainPageContract.View<MainListStoryBean.StoryBean,RotationPicBean.StoryBean>> implements MainPageContract.InteractionListener<List<MainListStoryBean.StoryBean>,List<RotationPicBean.StoryBean>>,MainPageContract.Presenter{

    private MainPageContract.View<MainListStoryBean.StoryBean,RotationPicBean.StoryBean> mView;
    private MainPageContract.Model mModel;
    private String param;
    private List<MainListStoryBean.StoryBean> mMainList;
    private List<RotationPicBean.StoryBean> mCircleList;


    public MainPagePresenter(String param,MainPageContract.View<MainListStoryBean.StoryBean,RotationPicBean.StoryBean> view){
        this.param=param;
        this.mView=view;
        mModel=new MainPageModel(param,this);
    }


    @Override
    public void onMainListLoadSeccess(List<MainListStoryBean.StoryBean> list) {
        mView.refreshMainList(list);
    }

    @Override
    public void onCircleListLoadSeccess(List<RotationPicBean.StoryBean> list) {
        mView.refreshCircleList(list);
    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void requstRefreshAll() {
        mModel.loadMainList();
    }

    @Override
    public void start(@Nullable String userPhone, @Nullable String userId) {
        mModel.loadCircleList();
        mModel.loadMainList();
    }
}
