package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.MyStorysBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.UserPageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPagePresenter extends BasePresenter<UserPageContract.View<MyStorysBean.ArrayBean>> implements UserPageContract.InteractionListener<List<MyStorysBean.ArrayBean>>, UserPageContract.Presenter {

    private UserPageContract.View<MyStorysBean.ArrayBean> mView;
    private UserPageContract.Model mModel;
    private List<MyStorysBean.ArrayBean> mStorys;
    private boolean isLoad = false;
    private String param;

    public UserPagePresenter(String param, UserPageContract.View<MyStorysBean.ArrayBean> view) {
        this.param = param;
        this.mView = view;
        this.mModel = new UserPageModel(param, this);
    }

    @Override
    public void requestRefreshMyStorys(String userId) {
        mModel.loadMyStorys();
    }

    @Override
    public void requestChangeUserName() {
        mModel.loadUserInfo();
    }

    @Override
    public void requsetChangeUserPortrait(String localPicturePath) {
        mModel.upLoadUserHead(localPicturePath);
    }

    @Override
    public void requsetDeleteOneStory() {
        mModel.loadMyStorys();
    }

    @Override
    public void checkOneStory() {

    }

    @Override
    public void onLoadMyStorysSeccess(List<MyStorysBean.ArrayBean> stories) {
        mView.refreshMyStorys(stories);
    }

    @Override
    public void onLoadMyStorysFail() {

    }

    @Override
    public void onUpLoadUserHeadSeccess() {
        mModel.loadUserInfo();
    }

    @Override
    public void onUpLoadUserHeadFail() {

    }

    @Override
    public void onChangeUserNameSeccess() {
        mModel.loadUserInfo();
    }

    @Override
    public void onChangeUserNameFail() {

    }

    @Override
    public void onLoadUserInfoSeccess(String userName, String headUrl) {
        mView.changeUserName(userName);
        mView.changeUserPortrait(headUrl);
    }

    @Override
    public void onLoadUserInfoFail() {

    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void start() {
        mModel.loadUserInfo();
        mModel.loadMyStorys();
    }
}
