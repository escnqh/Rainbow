package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.StoryReadContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.StoryReadModel;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/13.
 */

public class StoryReadPresenter extends BasePresenter<StoryReadContract.View<Story>>implements StoryReadContract.InteractionListener<Story>,StoryReadContract.Presenter {

    private StoryReadContract.View<Story> mView;
    private StoryReadContract.Model mModel;
    private String param;

    public StoryReadPresenter(String param,StoryReadContract.View<Story> view){
        this.param=param;
        this.mView=view;
        this.mModel=new StoryReadModel(param,this);
    }

    @Override
    public void requstShowStory() {
        mModel.loadStory();
    }

    @Override
    public void onLoadStorySeccess(Story story) {

    }

    @Override
    public void onLoadStoryFail() {

    }

    @Override
    public void start() {

    }
}
