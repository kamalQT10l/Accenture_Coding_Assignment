package com.accenture.kamal.albumlist.Core.Helpers;

import android.content.Context;

import com.accenture.kamal.albumlist.Model.AlbumData;

import java.util.List;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public interface GetAlbumHelper {
    interface View{
        void onGetAlbumSuccess(List<AlbumData> list);
        void onGetAlbumFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context);
    }
    interface Interactor{
        void initRetrofitCall(Context context);

    }
    interface onGetDataListener{
        void onSuccess( List<AlbumData> list);
        void onFailure(String message);
    }
}
