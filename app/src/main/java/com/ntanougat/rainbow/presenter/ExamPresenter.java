package com.ntanougat.rainbow.presenter;

import com.ntanougat.rainbow.base.BasePresenter;
import com.ntanougat.rainbow.contract.ExamContract;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.model.ExamModel;

/**
 * Created by Peelson on 2017/12/13.
 */

public class ExamPresenter extends BasePresenter<ExamContract.View<Story>> implements ExamContract.InteractionListener<Story>,ExamContract.Presenter {

    private ExamContract.View<Story> mView;
    private ExamContract.Model mModel;
    private String param;

    public ExamPresenter(String param,ExamContract.View<Story> mView){
        this.param=param;
        this.mView=mView;
        this.mModel=new ExamModel(param,this);
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
