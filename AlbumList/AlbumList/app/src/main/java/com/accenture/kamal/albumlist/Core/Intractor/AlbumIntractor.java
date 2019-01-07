package com.accenture.kamal.albumlist.Core.Intractor;

import android.content.Context;
import android.util.Log;

import com.accenture.kamal.albumlist.Core.Helpers.GetAlbumHelper;
import com.accenture.kamal.albumlist.Model.AlbumData;
import com.accenture.kamal.albumlist.Utils.AppUtils;
import com.accenture.kamal.albumlist.Webservice.Retrofit.RetrofitApis;
import com.accenture.kamal.albumlist.Webservice.Retrofit.RetrofitConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class AlbumIntractor implements GetAlbumHelper.Interactor{
    private String TAG = AlbumIntractor.class.getSimpleName();
    private GetAlbumHelper.onGetDataListener mOnGetDatalistener;



    public AlbumIntractor(GetAlbumHelper.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }


    @Override
    public void initRetrofitCall(Context context)
    {
        RetrofitApis mRetrofitApis = RetrofitConfig.getRetrofitinstance().create(RetrofitApis.class);

        retrofit2.Call<List<AlbumData>> mgetalbum = mRetrofitApis.getalbumdata();

        mgetalbum.enqueue(new Callback<List<AlbumData>>() {
            @Override
            public void onResponse(Call<List<AlbumData>> call, Response<List<AlbumData>> response) {
                AppUtils.showLog(TAG,"--------------api response-------------"+response);
                List<AlbumData> mNewAlbums = response.body();
                Collections.sort(mNewAlbums);
                mOnGetDatalistener.onSuccess( mNewAlbums);
            }

            @Override
            public void onFailure(Call<List<AlbumData>> call, Throwable t) {
                t.printStackTrace();
                AppUtils.showLog(TAG,"--------------api onFailure-------------");
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}
