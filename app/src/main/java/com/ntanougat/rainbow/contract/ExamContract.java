package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/13.
 */

public class ExamContract extends BaseContract {

    public interface Model {

        void loadStory();

    }

    public interface View<T> {

        void showStory(T t);
    }

    public interface Presenter {

        void requstShowStory();

    }

    public interface InteractionListener<T> {

        void onLoadStorySeccess(T t);

        void onLoadStoryFail();
    }

}
