package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.contract.StoryReadContract;
import com.ntanougat.rainbow.entities.Story;

/**
 * Created by Peelson on 2017/12/11.
 */

public class StoryReadModel implements StoryReadContract.Model {

    private StoryReadContract.InteractionListener<Story> mListener;

    private String param;

    public StoryReadModel(String param,StoryReadContract.InteractionListener<Story> mListenner){
        this.param=param;
        this.mListener=mListenner;
    }

    @Override
    public void loadStory() {
        
    }
}
