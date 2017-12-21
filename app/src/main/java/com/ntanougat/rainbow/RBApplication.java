package com.ntanougat.rainbow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ntanougat.rainbow.ui.activity.LoginActivity;
import com.ntanougat.rainbow.ui.activity.MainActivity;

/**
 * Created by Peelson on 2017/12/5.
 */

public class RBApplication extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences("loginInfo",MODE_PRIVATE);
        if(sharedPreferences.getBoolean("isLogin",false)){
            Intent intent=new Intent(RBApplication.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent=new Intent(RBApplication.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
