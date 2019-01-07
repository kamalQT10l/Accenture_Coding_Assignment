package com.accenture.kamal.albumlist.Webservice.Retrofit;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class RetrofitConfig {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitinstance()
    {

        if(retrofit==null)
        {
            retrofit= new retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
