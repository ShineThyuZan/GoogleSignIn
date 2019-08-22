package com.example.googlesignin;

import android.content.Context;

public class AppConfig extends AppConfigBase {
    public AppConfig(Context appContext)
    {

    }

    public AppConfig()
    {

    }

    public String getConnectionEncryptionPassword() {
        return "replace_me from config later";
    }

    public String getConnectionEncryptionSalt() {
        return "salt, replace me later";
    }
}