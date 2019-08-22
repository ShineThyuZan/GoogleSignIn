package com.example.googlesignin;

import android.content.Context;

import com.example.googlesignin.Mananger.ResturantMananger;

import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by smart04 on 6/19/17.
 */

public class PMAppSession extends AppCompatActivity {

    private static PMAppSession sInstanceAppSession;
    private AppConfig mAppConfig;
    private Context mAppContext;
    private SimpleDateFormat serverDateFormat;


    private PMAppSession(Context appContext, AppConfig appConfig) {
        this.mAppConfig = appConfig;
        this.mAppContext = appContext;


        serverDateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ", Locale.US );

        ResturantMananger.getInstance(appContext);
    }

    public static PMAppSession getInstance() {
        return sInstanceAppSession;
    }

    public static PMAppSession getInstance(Context appContext, AppConfig appConfig) {
        if (sInstanceAppSession == null) {
            sInstanceAppSession = new PMAppSession( appContext, appConfig );
        }
        return sInstanceAppSession;
    }

}

