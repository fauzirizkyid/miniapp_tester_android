package com.mcash.android.miniapptester.helper;

import android.app.Application;

import com.mcash.android.miniapptester.MiniAppTesterApp;
import com.tencent.tmf.mini.api.bean.MiniInitConfig;
import com.tencent.tmf.mini.api.proxy.MiniConfigProxy;
import com.tencent.tmfmini.sdk.annotation.ProxyService;

@ProxyService(proxy = MiniConfigProxy.class)
public class MiniConfigProxyImpl extends MiniConfigProxy {
    /**
     * 'Application' instance of current App
     *
     * @return
     */
    @Override
    public Application getApp() {
        return MiniAppTesterApp.sApp;
    }

    /**
     * Creates initialization configuration information
     *
     * @return
     */
    @Override
    public MiniInitConfig buildConfig() {
        MiniInitConfig.Builder builder = new MiniInitConfig.Builder();
        // Configuration file name in assets
        // Configure whether the mini program automatically requests necessary system permissions from the user when using APIs that require the permissions
        // Log switch, disabled by default
        return builder
                .configAssetName("tcmpp-android-configurations.json") // Configuration file name in assets
                .autoRequestPermission(true) // Configure whether the mini program automatically requests necessary system permissions from the user when using APIs that require the permissions
                .debug(true) // Log switch, disabled by default
                .build();
    }
}
