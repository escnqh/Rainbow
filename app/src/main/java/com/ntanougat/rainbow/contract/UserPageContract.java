package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageContract extends BaseContract {

    public interface Model {

        void loadUserInfo(boolean isLoad);

        void loadMyStorys(boolean isLoad);
    }

    public interface View<T> {

        void refreshMyStorys(ArrayList<T> arrayList);

        void changeUserName();

        void changeUserPortrait();

        void deleteOneStory();

    }

    public interface Presenter {

        void requestRefreshMyStorys();

        void requestChangeUserName();

        void requsetChangeUserPortrait();

        void requsetDeleteOneStory();

        void checkOneStory();
    }

    public interface InteractionListener<T> {

        void onLoadMyStorysSeccess(T t);

        void onLoadUserInfoSeccess(String userName,String headUrl);

        void onInteractionFail(int errorCode, String errorMsg);

    }
}
