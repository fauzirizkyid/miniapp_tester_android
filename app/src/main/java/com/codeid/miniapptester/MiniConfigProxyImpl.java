package com.codeid.miniapptester;

import android.app.Application;
import android.content.DialogInterface;
import android.util.Log;

import com.tencent.tmf.mini.api.bean.MiniInitConfig;
import com.tencent.tmf.mini.api.proxy.MiniConfigProxy;
import com.tencent.tmfmini.sdk.annotation.ProxyService;
import com.tencent.tmfmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.tmfmini.sdk.launcher.core.proxy.AbsMiniUiProxy;
import com.tencent.tmfmini.sdk.launcher.core.proxy.IMiniUiProxy;

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
