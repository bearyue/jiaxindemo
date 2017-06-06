package com.example.sen.jxdemo;

import android.app.Application;
import android.util.Log;

import com.jxccp.im.chat.manager.JXImManager;

/**
 * Created by Sen on 2017/4/20.
 */
public class DemoApplication extends Application {

    static final String TAG = "DemoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化SDK
        Log.w(TAG, "DemoApplication oncreate, " + getApplicationContext());
        JXImManager.getInstance().init(getApplicationContext(), "nzzyowdjmws0dw#dadaf#10001");
        JXImManager.getInstance().setDebugMode(true);
        JXImManager.Login.getInstance().setAutoLogin(false);
    }
}
