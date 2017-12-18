package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.IsTureBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Peelson on 2017/2/24.
 */

public interface ChangePortraitService {

    @Multipart
    @POST("ulhPhoto")
    Call<IsTureBean> getState(
            @Part("phone") RequestBody userPhone,
            @Part MultipartBody.Part file);
}
