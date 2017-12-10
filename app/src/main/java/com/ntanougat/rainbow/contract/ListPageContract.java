package com.ntanougat.rainbow.contract;

import java.util.ArrayList;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPageContract {

    public interface Model {

        void loadSearchResult();

    }

    public interface View<T> {

        void showResultList(ArrayList<T> arrayList);
    }

    public interface Presenter {

        void requstShowResult();

    }

    public interface InteractionListener<T> {

        void onInteractionSeccess(T t);

        void onInteractionFail(int errorCode, String errorMsg);
    }
}
