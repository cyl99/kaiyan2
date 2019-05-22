package com.cyl.kaiyan.utils;


import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp baseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApp getBaseApp() {
        return baseApp;
    }
}
