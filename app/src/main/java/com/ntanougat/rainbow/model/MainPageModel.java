package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.contract.MainPageContract;
import com.ntanougat.rainbow.entities.Story;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPageModel implements MainPageContract.Model {

    private MainPageContract.InteractionListener<ArrayList<Story>> mListener;

    private String param;

    public MainPageModel(String param,MainPageContract.InteractionListener<ArrayList<Story>> listener){
        this.param=param;
        this.mListener=listener;
    }

    @Override
    public void loadCircleList() {

    }

    @Override
    public void loadMainList() {

    }
}
