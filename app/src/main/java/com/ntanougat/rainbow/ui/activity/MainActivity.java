package com.ntanougat.rainbow.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.ui.fragment.ListPageFragment;
import com.ntanougat.rainbow.ui.fragment.MainPageFragment;
import com.ntanougat.rainbow.ui.fragment.UserPageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainPageFragment mainPageFragment;
    private ListPageFragment listPageFragment;
    private UserPageFragment userPageFragment;
    private FragmentManager fragmentManager;

    @BindView(R.id.navigation_bar_main)
    BottomNavigationBar navigationBarMain;
    @BindView(R.id.tool_bar_activity_main)
    Toolbar toolBarActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager=getSupportFragmentManager();
        initView();
        initFragment();
        initPermission();
    }

    private void initView() {
        setSupportActionBar(toolBarActivityMain);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
//            actionBar.setTitle(intent_name);
        }

        initNavigationBar();

    }

    private void initNavigationBar() {
        navigationBarMain.setActiveColor(R.color.united_color);
        navigationBarMain
                .addItem(new BottomNavigationItem(R.drawable.ic_mainpage, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_listpage, "搜索"))
                .addItem(new BottomNavigationItem(R.drawable.ic_userpage, "我的"))
                .initialise();
        navigationBarMain.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                changeFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void changeFragment(int position) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (position){
            case 0:
                if(mainPageFragment==null){

                }else {
                    transaction.show(mainPageFragment);
                }
                break;
            case 1:
                break;
            case 2:
                if (userPageFragment==null){
                    userPageFragment=UserPageFragment.newInstance(null);

                }
                transaction.commit();
        }

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mainPageFragment!=null){
            transaction.hide(mainPageFragment);
        }
        if(listPageFragment!=null){
            transaction.hide(listPageFragment);
        }
        if (userPageFragment!=null){
            transaction.hide(userPageFragment);
        }
    }

    private void initFragment() {
        mainPageFragment=new MainPageFragment();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragment,mainPageFragment);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            default:
                break;
        }
    }

    private void initPermission() {
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.RECORD_AUDIO);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CALL_PHONE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_CALL_LOG);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_CONTACTS);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_SMS);
        }
        if (!permissionList.isEmpty()) {
            String[] permissins = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissins, 1);
        } else {
        }
    }

}
