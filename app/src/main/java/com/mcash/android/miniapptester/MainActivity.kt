package com.mcash.android.miniapptester

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.text.TextUtils
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.codeid.miniapptester.databinding.ActivityMainBinding
import com.tencent.tmf.mini.api.TmfMiniSDK
import com.tencent.tmf.mini.api.bean.MiniCode
import com.tencent.tmf.mini.api.bean.MiniStartOptions
import com.tencent.tmfmini.sdk.launcher.core.proxy.QrCodeProxy


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mResultReceiver: ResultReceiver = object : ResultReceiver(android.os.Handler()) {
            override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
                if (resultCode != MiniCode.CODE_OK) {
                    //小程序启动错误
                    //mini program startup error
                    val errMsg = resultData.getString(MiniCode.KEY_ERR_MSG)
                    Toast.makeText(
                        this@MainActivity,
                        errMsg + resultCode,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.test.setOnClickListener {
//            val options = MiniStartOptions()
//            options.resultReceiver = mResultReceiver
//            options.entryPath = "tcmppgt1hj2nijw://applet/?appId=mpun6khtfydezrka"
            TmfMiniSDK.scan(this)
//            TmfMiniSDK.startMiniApp(
//                this,
//                "mpun6khtfydezrka",
//                options
//            )
        }


    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)

        if (requestCode == QrCodeProxy.REQUEST_CODE) {
            println("[Should Start By Link] sQrCodeProxy.REQUEST_CODE")
            if (resultCode == RESULT_OK) {
                println("[Should Start By Link] sQrCodeProxy.$resultCode")
                val jsonObject = TmfMiniSDK.getScanResult(requestCode, data)
                if (jsonObject != null) {
                    val result = jsonObject.optString("result", "")
                    if (!TextUtils.isEmpty(result)) {
                        println("[Should Start By Link] scan result: $result")
                        TmfMiniSDK.startMiniAppByLink(this, result, null)
//                        mCurrentCall.complete(null)
//                        mCurrentCall = null
                        return
                    }
                    val ret = HashMap<String, String>()
                    ret["scanType"] = jsonObject.optString("scanType")
                    ret["result"] = jsonObject.optString("result")
                    ret["charset"] = jsonObject.optString("charset")
//                    mCurrentCall.complete(ret)
//                    mCurrentCall = null
                    println("scan result: $ret")
                    return
                }
            }
//            mCurrentCall.onError("scan qrcode failed")
            return
        } else {
            return
        }
    }


}