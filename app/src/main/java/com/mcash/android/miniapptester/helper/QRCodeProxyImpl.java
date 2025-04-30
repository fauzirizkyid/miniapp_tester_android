package com.mcash.android.miniapptester.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.tencent.tmf.mini.api.proxy.MiniConfigProxy;
import com.tencent.tmfmini.sdk.annotation.ProxyService;
import com.tencent.tmfmini.sdk.launcher.core.proxy.QrCodeProxy;

import org.json.JSONArray;
import org.json.JSONObject;

@ProxyService(proxy = QRCodeProxyImpl.class)
public class QRCodeProxyImpl implements QrCodeProxy {

    @Override
    public Intent getIntent(Activity activity, boolean b) {
        return null;
    }

    @Override
    public void startScan(Activity activity, Intent intent) {

    }

    @Override
    public void startMiniAppByScan(Activity activity) {

    }

    @Override
    public String getResult(int i, Intent intent) {
        System.out.println("getResult [Should Start By Link] scan result: $result");
        return "";
    }

    @Override
    public JSONObject getScanResult(int i, Intent intent) {
        System.out.println("getScanResult [Should Start By Link] scan result: $result");
        return null;
    }

    @Override
    public JSONArray getResult(Intent intent) {
        System.out.println("getResult [Should Start By Link] scan result: $result");
        return null;
    }

    @Override
    public JSONArray decode(Context context, byte[] bytes, int i, int i1, int i2, int i3, int i4, int i5) {
        return null;
    }
}