package com.codeid.miniapptester.proxy;

import android.app.Application;

import com.codeid.miniapptester.MyApplication;
import com.tencent.tmf.mini.api.bean.MiniInitConfig;
import com.tencent.tmf.mini.api.proxy.MiniConfigProxy;
import com.tencent.tmfmini.sdk.annotation.ProxyService;

@ProxyService(proxy = MiniConfigProxy.class)
public class MiniConfigProxyImpl extends MiniConfigProxy {
    @Override
    public Application getApp() {
        return MyApplication.getInstance(); // ✅ Return the actual Application instance
    }

    @Override
    public MiniInitConfig buildConfig() {
        return new MiniInitConfig.Builder()
                .configAssetName("tcmpp-android-configurations.json") // Ensure this file exists in assets/
                .autoRequestPermission(true)
                .debug(true)
                .build();
    }
}
