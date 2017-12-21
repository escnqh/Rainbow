package com.ntanougat.rainbow.contract;

import com.ntanougat.rainbow.base.BaseContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peelson on 2017/12/10.
 */

public class MainPageContract extends BaseContract{

    public interface Model{

        void loadCircleList();

        void loadMainList();

    }

    public interface View<T,Y>{

        void refreshMainList(List<T> arrayList);

        void refreshCircleList(List<Y> list);
    }

    public interface Presenter{

        void requstRefreshAll();
    }

    public interface InteractionListener<T,Y>{

        void onMainListLoadSeccess(T t);

        void onCircleListLoadSeccess(Y y);

        void onInteractionFail(int errorCode, String errorMsg);

    }
}
