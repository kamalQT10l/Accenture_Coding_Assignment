package com.accenture.kamal.albumlist.Webservice.Retrofit;

import com.accenture.kamal.albumlist.Model.AlbumData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public interface RetrofitApis {
    @GET("albums")
    Call<List<AlbumData>> getalbumdata();
}
