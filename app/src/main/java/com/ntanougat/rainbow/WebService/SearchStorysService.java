package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.SearchResultBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Peelson on 2017/12/17.
 */

public interface SearchStorysService {
    @POST("searchWorks")
    Call<SearchResultBean> getState(
            @Query("title") String text
    );
}
