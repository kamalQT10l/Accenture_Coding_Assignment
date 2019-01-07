package com.accenture.kamal.albumlist.Utils;

import android.util.Log;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class AppUtils {

    private static boolean isDebugging=false;
    public static void showLog(String TAG,String message)
    {
        if(isDebugging)
        {
            Log.d(TAG,message);
        }
    }
}
