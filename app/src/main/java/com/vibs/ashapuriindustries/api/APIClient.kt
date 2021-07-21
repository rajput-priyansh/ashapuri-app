package com.vibs.ashapuriindustries.api

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.vibs.ashapuriindustries.BuildConfig
import com.shreejipackaging.utils.LibFile
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

object APIClient {

    fun getClient(application: Application): APIInterface {

        val baseUrl = "${BuildConfig.API_URL}"

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(200, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .writeTimeout(200, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    //.addHeader("set-cookie", sessionCookie)
                    .addHeader("Authorization",
                        "Bearer ${LibFile.getInstance(application)
                            .getString(LibFile.KEY_TOKEN, "")}"
                    )
                    .addHeader("Content-Type", "application/json")
//                    .addHeader("access_key", BuildConfig.API_ACCESS_TOCKEN)
//                    .addHeader("platform", BuildConfig.API_PLATFORM)
//                    .addHeader("app_version", BuildConfig.VERSION_NAME)//Android Version
//                    .addHeader("environment", BuildConfig.razorpay_mode)//Android build mode
                    .build()

                chain.proceed(request)
            }
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(StringConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

        return retrofit.create(APIInterface::class.java)
    }

    fun getClientWithoutToken(application: Application): APIInterface {

        val baseUrl = "${BuildConfig.API_URL}"

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(200, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .writeTimeout(200, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    //.addHeader("set-cookie", sessionCookie)
                    .addHeader("Content-Type", "application/json")
//                    .addHeader("access_key", BuildConfig.API_ACCESS_TOCKEN)
//                    .addHeader("platform", BuildConfig.API_PLATFORM)
//                    .addHeader("app_version", BuildConfig.VERSION_NAME)//Android Version
//                    .addHeader("environment", BuildConfig.razorpay_mode)//Android build mode
                    .build()

                chain.proceed(request)
            }
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(StringConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

        return retrofit.create(APIInterface::class.java)
    }

    private class StringConverterFactory : Converter.Factory() {
        override fun responseBodyConverter(
            inType: Type?,
            inAnnotations: Array<Annotation>?,
            inRetrofit: Retrofit?
        ): Converter<ResponseBody, String>? {
            return if (String::class.java == inType) {
                Converter { inValue -> inValue.string().replace("\"", "") }
            } else null
        }
    }
}