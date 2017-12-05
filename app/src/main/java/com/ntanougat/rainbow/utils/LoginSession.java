package com.ntanougat.rainbow.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ntanougat.rainbow.entities.UserInfo;

/**
 * Created by Peelson on 2017/12/5.
 */

public class LoginSession {

    static LoginSession sLoginSession;
    SharedPreferences mPreferences;

    private LoginSession(Context context) {
        mPreferences = context.getSharedPreferences(Constants.PREFS_NAME, 0);
    }

    public static void init(Context context) {
        if (sLoginSession == null) {
            sLoginSession = new LoginSession(context);
        }
    }

    public static LoginSession getLoginSession() {
        return sLoginSession;
    }

    /**
     * @param userInfo
     */
    public void saveUserInfo(UserInfo userInfo) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("userName", userInfo.getUserName());
        editor.putString("",userInfo.getPassword());
        editor.commit();
    }

    public void clear() {
        mPreferences.edit().clear().commit();
    }


    public boolean isLogined() {
        return !TextUtils.isEmpty(mPreferences.getString("token", ""));
    }
}
