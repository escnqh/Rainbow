package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPageContract extends BaseContract{

    public interface Model{

        void loadCircleList();

        void loadMainList();

    }

    public interface View<T>{

        void refreshAll(ArrayList<T> arrayList);
    }

    public interface Presenter{

        void requstRefreshAll();
    }

    public interface InteractionListener<T>{

        void onInteractionSeccess(T t);

        void onInteractionFail(int errorCode, String errorMsg);

    }
}
