package com.ntanougat.rainbow.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peelson on 2017/12/4.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    /**
     * @param context 上下文环境
     * @param name 数据库名字
     * @param factory 一个可选的游标工厂（通常是Null）
     * @param version 数据库模型版本的整数
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 在数据库第一次创建的时候会调用这个方法
     * @param sqLiteDatabase 根据需要对传入的SQLiteDatabase 对象填充表和初始化数据
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    /**
     * 当数据库需要修改的时候（两个数据库版本不同），Android系统会主动的调用这个方法。
     * 一般我们在这个方法里边删除数据库表，并建立新的数据库表。
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 每次成功打开数据库后首先被执行
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
