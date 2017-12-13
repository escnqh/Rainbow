package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.contract.ExamContract;
import com.ntanougat.rainbow.entities.Story;

/**
 * Created by Peelson on 2017/12/13.
 */

public class ExamModel implements ExamContract.Model {

    private ExamContract.InteractionListener<Story> mListener;
    private String param;

    public ExamModel(String param,ExamContract.InteractionListener<Story> mListener){
        this.param=param;
        this.mListener=mListener;
    }

    public void loadStory() {

    }
}
