package com.codeid.miniapptester.proxy;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

import com.codeid.miniapptester.R;
import com.tencent.tmfmini.sdk.BuildConfig;
import com.tencent.tmfmini.sdk.annotation.ProxyService;
import com.tencent.tmfmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.tmfmini.sdk.launcher.core.proxy.BaseMiniAppProxyImpl;
import com.tencent.tmfmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.tmfmini.sdk.launcher.log.QMLog;
import com.tencent.tmfmini.sdk.launcher.ui.MoreItem;
import com.tencent.tmfmini.sdk.launcher.ui.MoreItemList;
import com.tencent.tmfmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.tmfmini.sdk.ui.DefaultMoreItemSelectedListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fmtnimi.gt;

@ProxyService(proxy = MiniAppProxy.class)
public class MiniAppProxyImpl extends BaseMiniAppProxyImpl {

    @Override
    public String getAppVersion() {
        return "1.0.0";
    }

    @Override
    public String getAppName() {
        return "MiniApp Tester";
    }

    @Override
    public boolean isDebugVersion() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Drawable getDrawable(Context context, String s, int i, int i1, Drawable drawable) {
        return null;
    }

    @Override
    public boolean openChoosePhotoActivity(Context context, int i, IChoosePhotoListner iChoosePhotoListner) {
        return false;
    }

    @Override
    public boolean openImagePreview(Context context, int i, List<String> list) {
        return false;
    }

    @Override
    public boolean onCapsuleButtonMoreClick(IMiniAppContext iMiniAppContext) {
        Log.e("TAG", "onCapsuleButtonCloseClick" + iMiniAppContext.getMiniAppInfo());
        //handle close mini app event
        return false;
    }

    @Override
    public boolean uploadUserLog(String s, String s1) {
        return false;
    }


    @Override
    public OnMoreItemSelectedListener getMoreItemSelectedListener() {
        return new DefaultMoreItemSelectedListener();
    }

    @Override
    public ArrayList<MoreItem> getMoreItems(IMiniAppContext miniAppContext, MoreItemList.Builder builder) {
        builder.addRestart(this.getString(miniAppContext, R.string.mini_sdk_more_item_setting_0), R.mipmap.i_refresh);
        return builder.build();
    }


    private String getString(IMiniAppContext miniAppContext, int id) {
        return miniAppContext.getContext().getString(id);
    }
}