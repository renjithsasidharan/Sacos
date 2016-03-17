package com.sacos.sacosandorid;

import android.util.Log;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;


/**
 * Created by renjith on 31/01/16.
 */
public class OkHttpHandler {

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getClient() {
        if (okHttpClient == null) {

            okHttpClient = new OkHttpClient();
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Log.d("OkHttpHandler", "Request url = " + request.urlString());
                    return chain.proceed(chain.request());
                }
            });

            // Cache interceptor
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    int maxAge = 600; // read from cache for 10 mins
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                }
            });

            //setup cache
            File httpCacheDirectory = new File("responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(httpCacheDirectory, cacheSize);

            //add cache to the client
            okHttpClient.setCache(cache);

            //Add stecho interceptor
            okHttpClient.networkInterceptors().add(new StethoInterceptor());

        }
        return okHttpClient;
    }
}
