package com.mcash.android.miniapptester;

import android.app.Application;
import android.content.Context;

public class MiniAppTesterApp extends Application {
    public static Application sApp;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sApp = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        configureApp();
    }

    /**
     * config your app main page here
     */
    private void configureApp() {
        //custom app config with your own UI infos

    }
}
