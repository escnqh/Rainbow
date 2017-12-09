package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.Story;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageModel implements UserPageContract.Model {
    private UserPageContract.InteractionListener<ArrayList<Story>> mListener;
    private String param;

    public UserPageModel(String param, UserPageContract.InteractionListener<ArrayList<Story>> mListener){
        this.param=param;
        this.mListener=mListener;
    }

    @Override
    public void loadUserInfo(boolean isLoad) {

    }

    @Override
    public void loadMyStorys(boolean isLoad) {

    }
}
