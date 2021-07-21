package com.vibs.ashapuriindustries.api;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This interceptor put all the Cookies in Preferences in the Request.
 * Your implementation on how to get the Preferences MAY VARY.
 */
public class AddCookiesInterceptor implements Interceptor {

    public static final String PREF_COOKIES = "PREF_COOKIES";
    private Context context;

    public AddCookiesInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        //HashSet<String> preferences = (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context).getStringSet(PREF_COOKIES, new HashSet<String>());
//        LibFile libFile = LibFile.Companion.getInstance(context);

        Request original = chain.request();
        /*if(original.url().toString().contains("distributor")){
            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);
            }
        }*/
//        for (String cookie : libFile.getStringSet(LibFile.KEY_SESSION_ID, new HashSet<String>())) {
//            builder.addHeader("Cookie", cookie);
//        }

        return chain.proceed(builder.build());
    }
}