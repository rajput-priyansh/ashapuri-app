package com.vibs.ashapuriindustries.api;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {

    private Context context;

    public ReceivedCookiesInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

//            HashSet<String> cookies = (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context).getStringSet("PREF_COOKIES", new HashSet<String>());
//            LibFile libFile = LibFile.Companion.getInstance(context);
//            HashSet<String> cookies = libFile.getStringSet(LibFile.KEY_SESSION_ID, new HashSet<String>());

            /*for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }*/

            //Store cookies single times only
            /*if (cookies.size() > 0) {

                libFile.setStringSet(LibFile.KEY_SESSION_ID, cookies);
                *//*SharedPreferences.Editor memes = PreferenceManager.getDefaultSharedPreferences(context).edit();
                memes.putStringSet("PREF_COOKIES", cookies).apply();
                memes.commit();*//*
            }*/
        }

        return originalResponse;
    }
}