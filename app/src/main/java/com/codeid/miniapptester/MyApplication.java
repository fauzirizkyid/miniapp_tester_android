package com.codeid.miniapptester;

import android.app.Application;
import com.tencent.tmf.mini.api.TmfMiniSDK;
import com.tencent.tmf.mini.api.bean.MiniInitConfig;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
