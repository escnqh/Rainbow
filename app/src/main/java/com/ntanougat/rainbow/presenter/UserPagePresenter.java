package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.UserPageModel;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPagePresenter extends BasePresenter<UserPageContract.View<Story>> implements UserPageContract.InteractionListener<ArrayList<Story>>, UserPageContract.Presenter {

    private UserPageContract.View<Story> mView;
    private UserPageContract.Model mModel;
    private ArrayList<Story> mStorys;
    private boolean isLoad = false;
    private String param;

    public UserPagePresenter(String param, UserPageContract.View<Story> view) {
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
    public void onLoadMyStorysSeccess(ArrayList<Story> stories) {

    }

    @Override
    public void onLoadMyStorysFail() {

    }

    @Override
    public void onUpLoadUserHeadSeccess() {

    }

    @Override
    public void onUpLoadUserHeadFail() {

    }

    @Override
    public void onChangeUserHeadSeccess() {

    }

    @Override
    public void onChangeUserHeadFail() {

    }

    @Override
    public void onLoadUserInfoSeccess(String userName, String headUrl) {

    }

    @Override
    public void onLoadUserInfoFail() {

    }

    @Override
    public void onInteractionFail(int errorCode, String errorMsg) {

    }

    @Override
    public void start() {

    }
}
