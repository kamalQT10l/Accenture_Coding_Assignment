package com.accenture.kamal.albumlist.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by kamal on 7/1/19.
 */

public class SessionManager {
    private static SessionManager mSessionManager;

    public static SharedPreferences mSharedPreferences;

    public Context mContext;

    public static SharedPreferences.Editor mEditor;

    // Shared Preferences file name
    String PREFERENCE_NAME = "Albumlist_app_preference";
    // Shared Preferences mode
    int PRIVATE_MODE = 0;

    private SessionManager(Context context)
    {
        this.mContext=context;
        mSharedPreferences=mContext.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        mEditor=mSharedPreferences.edit();
    }

    /**
     * getInstance method is used to initialize SessionManager singelton
     * instance
     * @param context context instance
     * @return Singelton session manager instance
     */
    public static SessionManager getInstance(Context context) {
        if (mSessionManager == null) {
            mSessionManager = new SessionManager(context);
        }
        return mSessionManager;
    }

    public <T> void setList(String key, List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        set(key, json);
    }

    public static void set(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getPrefData(String key)
    {
        return mSharedPreferences.getString(key,"");
    }

}
