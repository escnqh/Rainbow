package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/11.
 */

public class StoryReadContract extends BaseContract {

    public interface Model {

        void loadStory();

    }

    public interface View<T> {

        void showStory(ArrayList<T> arrayList);
    }

    public interface Presenter {

        void requstShowStory();

    }

    public interface InteractionListener<T> {

        void onInteractionSeccess(T t);

        void onInteractionFail(int errorCode, String errorMsg);
    }

}
