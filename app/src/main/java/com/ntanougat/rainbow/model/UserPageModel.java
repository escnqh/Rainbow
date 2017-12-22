package com.ntanougat.rainbow.model;

import android.util.Log;

import com.ntanougat.rainbow.WebService.ChangePortraitService;
import com.ntanougat.rainbow.WebService.GetStroysService;
import com.ntanougat.rainbow.WebService.GetUserInfoService;
import com.ntanougat.rainbow.contract.UserPageContract;
import com.ntanougat.rainbow.entities.IsTureBean;
import com.ntanougat.rainbow.entities.MyStorysBean;
import com.ntanougat.rainbow.entities.Story;
import com.ntanougat.rainbow.entities.UserInfo;
import com.ntanougat.rainbow.webApi.ChangePortraitApi;
import com.ntanougat.rainbow.webApi.GetStorysApi;
import com.ntanougat.rainbow.webApi.GetUserInfoApi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/9.
 */

public class UserPageModel implements UserPageContract.Model {
    private UserPageContract.InteractionListener<List<MyStorysBean.ArrayBean>> mListener;
    private String param;
    private String userId;
    private String userPhone;
    private String userName;
    private String headUrl;


    public UserPageModel(String param, UserPageContract.InteractionListener<List<MyStorysBean.ArrayBean>> mListener){
        this.param=param;
        this.mListener=mListener;
    }

    @Override
    public void loadUserInfo(String userphone) {
        getUserInfo(userphone);
    }

    @Override
    public void loadMyStorys(String userid) {
        getMyStory(userid);
    }

    @Override
    public void upLoadUserHead(String localPicturePath) {
        ChangePortraitApi changePortraitApi=new ChangePortraitApi();
        ChangePortraitService changePortraitService=changePortraitApi.getService();
        File file=new File(localPicturePath);
        RequestBody requestBody=RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part body=MultipartBody.Part.createFormData("file",file.getName(),requestBody);
        final RequestBody userphone=RequestBody.create(null,userPhone);
        Call<IsTureBean> call_changePortrait=changePortraitService.getState(userphone,body);
        call_changePortrait.enqueue(new Callback<IsTureBean>() {
            @Override
            public void onResponse(Call<IsTureBean> call, Response<IsTureBean> response) {
                if(response.body().getResult().equals("1")){
                    mListener.onUpLoadUserHeadSeccess(userPhone);
                    Log.i("Change userhead seccess",userPhone);
                }
                else{
                    mListener.onUpLoadUserHeadFail();
                    Log.i("Change userhead failed",userPhone);
                }
            }

            @Override
            public void onFailure(Call<IsTureBean> call, Throwable t) {
                    mListener.onUpLoadUserHeadFail();
                Log.i("Change userhead failed",userPhone);
            }
        });


    }

    private void getUserInfo(String userphone) {
        GetUserInfoApi getUserInfoApi=new GetUserInfoApi();
        GetUserInfoService getUserInfoService=getUserInfoApi.getService();
        Call<UserInfo> call_userInfo=getUserInfoService.getState(userphone);
        call_userInfo.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                Log.i("GetUserInfoSeccessed","    "+userPhone);
                if (response.body()!=null){
                    userId=response.body().getUid();
                    userName=response.body().getUname();
                    userPhone=response.body().getUphone();
                    headUrl=response.body().getHeadUrl();
                    mListener.onLoadUserInfoSeccess(userName,headUrl);
                }else {
                    mListener.onLoadUserInfoFail();
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                mListener.onLoadUserInfoFail();
                Log.i("GetUserInfoFailed",t+"");
            }
        });
    }

    public void getMyStory(final String userid) {
        GetStorysApi getStorysApi=new GetStorysApi();
        GetStroysService getStroysService=getStorysApi.getService();
        Call<MyStorysBean> call_myStorys=getStroysService.getState(userid);
        call_myStorys.enqueue(new Callback<MyStorysBean>() {
            @Override
            public void onResponse(Call<MyStorysBean> call, Response<MyStorysBean> response) {
                Log.i("GetMyStorySeccessed", "    "+userid);
                if(response.body().getArray().size()!=0){
                    mListener.onLoadMyStorysSeccess(response.body().getArray());
                }else{
                    mListener.onLoadMyStorysFail();
                }
//
            }

            @Override
            public void onFailure(Call<MyStorysBean> call, Throwable t) {
                mListener.onLoadMyStorysFail();
                Log.i("GetMyStoryFailed", "    "+userid+"    "+t);
            }
        });
    }
}
