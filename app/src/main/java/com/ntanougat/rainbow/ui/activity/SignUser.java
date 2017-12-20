package com.ntanougat.rainbow.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.SignService;
import com.ntanougat.rainbow.entities.IsTureBean;
import com.ntanougat.rainbow.webApi.SignApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 注册用户
 * Created by 17823 on 2017/12/11.
 */

public class SignUser extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        initSign();
        initCacel();
    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            finish();
        }
        return false;
    }

    public void initSign(){
        Button ok=(Button)findViewById(R.id.OK);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText use_ED=(EditText) findViewById(R.id.use_login);
                EditText pwd_ED=(EditText)findViewById(R.id.pwd_login);
                EditText Ispwd_ED=(EditText)findViewById(R.id.pwd_Islogin);
                EditText usename_ED=(EditText)findViewById(R.id.use_name);
                final String uphone=use_ED.getText().toString();
                final String upsw=pwd_ED.getText().toString();
                String Ispwd=Ispwd_ED.getText().toString();
                final String uname=usename_ED.getText().toString();
                Log.i("num",uphone);
                Log.i("pwd",upsw);
                if(uphone.isEmpty()){
                    new AlertDialog.Builder(SignUser.this).setTitle("系统提示")
                            .setIcon(R.mipmap.ic_launcher).setMessage("账户不能为空！")
                            .setPositiveButton("确定",null).show();
                }
                else{
                    if(upsw.isEmpty()&&Ispwd.isEmpty()){
                        new AlertDialog.Builder(SignUser.this).setTitle("系统提示")
                                .setIcon(R.mipmap.ic_launcher).setMessage("密码不能为空！")
                                .setPositiveButton("确定",null).show();
                    }
                    else if(upsw.equals(Ispwd)){
                        SignApi signApi=new SignApi();
                        SignService signService=signApi.getService();
                        Call<IsTureBean> call_lign=signService.getState(uphone,uname,upsw);
                        call_lign.enqueue(new Callback<IsTureBean>() {
                            @Override
                            public void onResponse(Call<IsTureBean> call, Response<IsTureBean> response) {
                                if(response.body().getResult().equals("1")) {
                                    Intent intent_Sign=new Intent(SignUser.this, LoginActivity.class);
                                    intent_Sign.putExtra("uphone",uphone );
                                    //intent.putExtra("uname", uname);
                                    intent_Sign.putExtra("upsw", upsw);
                                    Toast.makeText(SignUser.this, "恭喜注册完成！", Toast.LENGTH_SHORT).show();
                                    startActivity(intent_Sign);
                                }
                                else if(response.body().getResult().equals("0")){
                                    Toast.makeText(SignUser.this, "此号已注册！", Toast.LENGTH_SHORT).show();
                                }
                                else if(response.body().getResult().equals("-1")){
                                    Toast.makeText(SignUser.this, "账号或密码格式出错！", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onFailure(Call<IsTureBean> call, Throwable t) {
                                Toast.makeText(SignUser.this, "注册失败！请检查网络设置...", Toast.LENGTH_SHORT).show();
                                //System.out.println("call_sign_onFailure" + t);
                            }
                        });
                    }
                    else{
                        new AlertDialog.Builder(SignUser.this).setTitle("系统提示")
                                .setIcon(R.mipmap.ic_launcher).setMessage("密码前后不一致！")
                                .setPositiveButton("确定",null).show();
                    }
                }
            }
        });
    }

    public void initCacel(){
        Button cacel=(Button)findViewById(R.id.Cacel);
        cacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUser.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
