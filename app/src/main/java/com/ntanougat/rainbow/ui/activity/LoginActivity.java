package com.ntanougat.rainbow.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.GetUserInfoService;
import com.ntanougat.rainbow.WebService.LoginService;
import com.ntanougat.rainbow.entities.IsTureBean;
import com.ntanougat.rainbow.entities.UserInfo;
import com.ntanougat.rainbow.webApi.GetUserInfoApi;
import com.ntanougat.rainbow.webApi.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/10.
 */

public class LoginActivity extends Activity {

    private SharedPreferences sharedPreferences;
    private String userPhone;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences=getSharedPreferences("loginInfo",MODE_PRIVATE);
        initLogin();
        initSigin();
    }

    public void initLogin(){
        Button bt_lodin=(Button)findViewById(R.id.Login_btn);
        bt_lodin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText use_ED=(EditText) findViewById(R.id.use_login);
                EditText pwd_ED=(EditText)findViewById(R.id.pwd_login);
                userPhone=use_ED.getText().toString();
                final String userPassword=pwd_ED.getText().toString();
                //final String userPhone= (String) getIntent().getSerializableExtra("uphone");
                //final String userPassword= (String) getIntent().getSerializableExtra("upsw");
                LoginApi loginApi=new LoginApi();
                LoginService loginService=loginApi.getService();
                Call<IsTureBean> call_lign=loginService.getState(userPhone,userPassword);
                call_lign.enqueue(new Callback<IsTureBean>() {
                    @Override
                    public void onResponse(Call<IsTureBean> call, Response<IsTureBean> response) {
                        if(response.body().getResult().equals("1")) {
                            Log.i("Login Seccess","LOGINNNNNNNNN"+userPhone);

                            getUserInfo();
                            /*Intent intent_login = new Intent(LoginActivity.this, TestActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);*/

                        }
                        else{
                            Toast.makeText(LoginActivity.this, "账号或密码错误！请检查...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<IsTureBean> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "登录失败，请检查网络设置", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void getUserInfo() {

        GetUserInfoApi getUserInfoApi=new GetUserInfoApi();
        GetUserInfoService getUserInfoService=getUserInfoApi.getService();
        Call<UserInfo> call=getUserInfoService.getState(userPhone);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if(response.body()!=null){

                }
                Intent intent_login=new Intent(LoginActivity.this, MainActivity.class);
                intent_login.putExtra("uphone",userPhone );
                intent_login.putExtra("userId", response.body().getUid());
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("isLogin",true);
                editor.putString("userPhone",userPhone);
                editor.putString("userId",response.body().getUid());
                editor.commit();
                startActivity(intent_login);
                Log.i("GetUserInfoSeccess",userPhone+"   "+response.body().getUid());
                finish();
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });
    }

    public void initSigin(){
        Button bt_sign=(Button)findViewById(R.id.Sign_btn);
        bt_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUser.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
