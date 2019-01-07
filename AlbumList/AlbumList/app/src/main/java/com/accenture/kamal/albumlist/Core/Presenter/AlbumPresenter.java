package com.accenture.kamal.albumlist.Core.Presenter;

import android.content.Context;

import com.accenture.kamal.albumlist.Core.Helpers.GetAlbumHelper;
import com.accenture.kamal.albumlist.Core.Intractor.AlbumIntractor;
import com.accenture.kamal.albumlist.Model.AlbumData;

import java.util.List;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class AlbumPresenter implements GetAlbumHelper.Presenter,GetAlbumHelper.onGetDataListener{
    private GetAlbumHelper.View mGetDataView;
    private AlbumIntractor mIntractor;
    public AlbumPresenter(GetAlbumHelper.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new AlbumIntractor(this);
    }

    @Override
    public void onSuccess(List<AlbumData> list) {
        mGetDataView.onGetAlbumSuccess(list);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetAlbumFailure(message);
    }

    @Override
    public void getDataFromURL(Context context) {
        mIntractor.initRetrofitCall(context);
    }
}
