package com.ntanougat.rainbow.contract;

import java.util.List;

/**
 * Created by Peelson on 2017/12/10.
 */

public class ListPageContract {

    public interface Model {

        void loadSearchResult(String text);

    }

    public interface View<T> {

        void showResultList(List<T> arrayList);
    }

    public interface Presenter {

        void requstShowResult(String text);

    }

    public interface InteractionListener<T> {

        void onInteractionSeccess(T t);

        void onInteractionFail(int errorCode, String errorMsg);
    }
}
