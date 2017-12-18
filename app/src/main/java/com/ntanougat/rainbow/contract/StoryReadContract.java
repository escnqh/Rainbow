package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/11.
 */

public class StoryReadContract extends BaseContract {

    public interface Model {

        void loadStory(String storyId);

    }

    public interface View<T> {

        void showStory(T t);
    }

    public interface Presenter {

        void requstShowStory(String storyId);

    }

    public interface InteractionListener<T> {

        void onLoadStorySeccess(T t);

        void onLoadStoryFail();
    }

}
