package com.ntanougat.rainbow.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.LoginService;
import com.ntanougat.rainbow.adapter.CardFragmentPagerAdapter;
import com.ntanougat.rainbow.adapter.CardPagerAdapter;
import com.ntanougat.rainbow.entities.CardItem;
import com.ntanougat.rainbow.entities.IsLoginBean;
import com.ntanougat.rainbow.utils.LoginSession;
import com.ntanougat.rainbow.utils.ShadowTransformer;
import com.ntanougat.rainbow.webApi.LoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_login;
    private EditText edt_phone;
    private EditText edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login=findViewById(R.id.btn_login);
        edt_phone=findViewById(R.id.tv_phone);
        edt_password=findViewById(R.id.tv_password);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                LoginApi loginApi=new LoginApi();
                LoginService loginService=loginApi.getService();
                Call<IsLoginBean> call_login=loginService.getState("123456","123456");
                call_login.enqueue(new Callback<IsLoginBean>() {
                    @Override
                    public void onResponse(Call<IsLoginBean> call, Response<IsLoginBean> response) {
                        if (response.body()==null){
                            Toast.makeText(MainActivity.this,"返回值空",Toast.LENGTH_SHORT).show();
                        }else {
                            Log.i("MMMMMMMMMMMMM",response.body().getResult());
                            if(response.body().getResult().equals("0")){
                                Toast.makeText(MainActivity.this,"0,成功",Toast.LENGTH_SHORT).show();
                            }else if(response.body().getResult().equals("1")){
                                Toast.makeText(MainActivity.this,"1,失败",Toast.LENGTH_SHORT).show();
                            }else if (response.body().getResult().equals("ERROR")){
                                Toast.makeText(MainActivity.this,"ERROR,失败",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<IsLoginBean> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }


//    @Override
//    protected BasePresenter createPresenter() {
//        return null;
//    }
}
