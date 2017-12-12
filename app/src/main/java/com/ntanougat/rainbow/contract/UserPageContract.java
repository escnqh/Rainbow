package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageContract extends BaseContract {

    public interface Model {

        void loadUserInfo();

        void loadMyStorys();

        void upLoadUserHead(String localPicturePath);

    }

    public interface View<T> {

        void refreshMyStorys(ArrayList<T> arrayList);

        void changeUserName(String userName);

        void changeUserPortrait(String headUrl);

        void deleteOneStory();

    }

    public interface Presenter {

        void requestRefreshMyStorys(String userId);

        void requestChangeUserName();

        void requsetChangeUserPortrait(String localPicturePath);

        void requsetDeleteOneStory();

        void checkOneStory();
    }

    public interface InteractionListener<T> {

        void onLoadMyStorysSeccess(T t);
        void onLoadMyStorysFail();
        void onUpLoadUserHeadSeccess();
        void onUpLoadUserHeadFail();
        void onChangeUserHeadSeccess();
        void onChangeUserHeadFail();
        void onLoadUserInfoSeccess(String userName,String headUrl);
        void onLoadUserInfoFail();
        void onInteractionFail(int errorCode, String errorMsg);

    }
}
