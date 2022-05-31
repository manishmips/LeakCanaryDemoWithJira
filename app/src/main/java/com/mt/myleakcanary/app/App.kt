package com.mt.myleakcanary.app

import android.app.Application
import android.os.Build
import android.text.TextUtils
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.mt.leakcanarysample.LeakCanaryUploaderInit
import com.mt.myleakcanary.util.Util
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LeakCanaryUploaderInit.initLeakCanary()
        getHeadersInterceptor()
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(this))
            .build()
        Util.findTwoMissingNumbers(intArrayOf(1, 2, 3, 4,5, 6,9,10), 10)
    }
    private fun getHeadersInterceptor(): Interceptor? {
        return Interceptor { chain1: Interceptor.Chain ->
            val original = chain1.request()
            val requestBuilder: Request.Builder = getRequestBuilderWithRetryCount(original)
            if (original.url().url().path.contains("refresh-token")) {
                requestBuilder.header(
                    "Authorization",
                    "Bearer "
                )
            } else requestBuilder.header(
                "Authorization",
                "Bearer "
            )
            requestBuilder.header("Content-Type", "application/x-www-form-urlencoded")
            requestBuilder.header(
                "language","en"
            )
            requestBuilder.header("appversion", "1.0")
            requestBuilder.header("devicemodel", "ee")
            requestBuilder.header("devicetype", "ANDROID")
            requestBuilder.header("osversion", Build.VERSION.SDK_INT.toString())
            requestBuilder.header(
                "country","IN"
            )
            requestBuilder.header("deviceid", "eee")
            requestBuilder.header("brand", "KFC")
            requestBuilder.header("timezone", "333")
            requestBuilder.header("channel", "kfcapp")
            requestBuilder.header("appbundle", "")
            requestBuilder.header(
                "truecountry","IN"
            )
            val request = requestBuilder.build()
            chain1.proceed(request)
        }
    }
    private fun getRequestBuilderWithRetryCount(original: Request): Request.Builder {
        var retrycount = 1
        if (!TextUtils.isEmpty(original.header("retrycount"))) {
            retrycount = original.header("retrycount")!!.toInt()
            retrycount++
        }
        return original.newBuilder()
            .method(original.method(), original.body())
            .header("retrycount", retrycount.toString())
    }
}