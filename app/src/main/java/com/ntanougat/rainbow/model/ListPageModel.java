package com.ntanougat.rainbow.model;

import com.ntanougat.rainbow.contract.ListPageContract;
import com.ntanougat.rainbow.entities.Story;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPageModel implements ListPageContract.Model {

    private ListPageContract.InteractionListener<ArrayList<Story>> mListener;
    private String param;

    public ListPageModel(String param, ListPageContract.InteractionListener<ArrayList<Story>> listener) {
        this.param = param;
        this.mListener = listener;
    }

    @Override
    public void loadSearchResult() {

    }

}
