package com.ntanougat.rainbow.WebService;

import com.ntanougat.rainbow.entities.IsTureBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Peelson on 2017/12/17.
 */

public interface UpLoadStoryService {

    @Multipart
    @POST("ulStory")
    Call<IsTureBean> getByOne(
            @Part("uid") RequestBody userId,
            @Part("title") RequestBody storyTitle,
            @Part("g_id") RequestBody g_id1,
            @Part("g_content") RequestBody g_content1,
            @Part MultipartBody.Part file1);
    Call<IsTureBean> getByTwo(
            @Part("uid") RequestBody userId,
            @Part("title") RequestBody storyTitle,
            @Part("g_id") RequestBody g_id1,
            @Part("g_content") RequestBody g_content1,
            @Part MultipartBody.Part file1,
            @Part("g_id") RequestBody g_id2,
            @Part("g_content") RequestBody g_content2,
            @Part MultipartBody.Part file2);
    Call<IsTureBean> getByThree(
            @Part("uid") RequestBody userId,
            @Part("title") RequestBody storyTitle,
            @Part("g_id") RequestBody g_id1,
            @Part("g_content") RequestBody g_content1,
            @Part MultipartBody.Part file1,
            @Part("g_id") RequestBody g_id2,
            @Part("g_content") RequestBody g_content2,
            @Part MultipartBody.Part file2,
            @Part("g_id") RequestBody g_id3,
            @Part("g_content") RequestBody g_content3,
            @Part MultipartBody.Part file3);
    Call<IsTureBean> getByFour(
            @Part("uid") RequestBody userId,
            @Part("title") RequestBody storyTitle,
            @Part("g_id") RequestBody g_id1,
            @Part("g_content") RequestBody g_content1,
            @Part MultipartBody.Part file1,
            @Part("g_id") RequestBody g_id2,
            @Part("g_content") RequestBody g_content2,
            @Part MultipartBody.Part file2,
            @Part("g_id") RequestBody g_id3,
            @Part("g_content") RequestBody g_content3,
            @Part MultipartBody.Part file3,
            @Part("g_id") RequestBody g_id4,
            @Part("g_content") RequestBody g_content4,
            @Part MultipartBody.Part file4);
    Call<IsTureBean> getByFive(
            @Part("uid") RequestBody userId,
            @Part("title") RequestBody storyTitle,
            @Part("g_id") RequestBody g_id1,
            @Part("g_content") RequestBody g_content1,
            @Part MultipartBody.Part file1,
            @Part("g_id") RequestBody g_id2,
            @Part("g_content") RequestBody g_content2,
            @Part MultipartBody.Part file2,
            @Part("g_id") RequestBody g_id3,
            @Part("g_content") RequestBody g_content3,
            @Part MultipartBody.Part file3,
            @Part("g_id") RequestBody g_id4,
            @Part("g_content") RequestBody g_content4,
            @Part MultipartBody.Part file4,
            @Part("g_id") RequestBody g_id5,
            @Part("g_content") RequestBody g_content5,
            @Part MultipartBody.Part file5);
}
