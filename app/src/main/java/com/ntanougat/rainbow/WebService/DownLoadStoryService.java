package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Peelson on 2017/12/17.
 */

public interface DownLoadStoryService {
    @POST("download")
    Call<DownLoadStoryBean> getState(
            @Query("p_id") String p_id
    );
}
