package com.sacos.sacosandorid;

import android.app.Application;
import android.content.Context;

/**
 * Created by renjith on 06/02/16.
 */
public class SacosAndroid extends Application{
    private static Context context;

    public void onCreate() {
        super.onCreate();
        SacosAndroid.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return SacosAndroid.context;
    }
}
