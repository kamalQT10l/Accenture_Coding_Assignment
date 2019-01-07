package com.accenture.kamal.albumlist.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.accenture.kamal.albumlist.Adapter.AlbumListAdapter;
import com.accenture.kamal.albumlist.Core.Helpers.GetAlbumHelper;
import com.accenture.kamal.albumlist.Core.Presenter.AlbumPresenter;
import com.accenture.kamal.albumlist.Model.AlbumData;
import com.accenture.kamal.albumlist.Preferences.SessionManager;
import com.accenture.kamal.albumlist.R;
import com.accenture.kamal.albumlist.Utils.AppUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AlbumActivity extends AppCompatActivity implements GetAlbumHelper.View {

    private String TAG = AlbumActivity.class.getSimpleName();
    private AlbumPresenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AlbumListAdapter mAlbumListAdapter;
    private String Album_cache_key="ALBUM_CACHE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new AlbumPresenter(this);
        mPresenter.getDataFromURL(getApplicationContext());
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void onGetAlbumSuccess(List<AlbumData> list) {
        AppUtils.showLog(TAG,"-----onGetAlbumSuccess----------");
        mAlbumListAdapter = new AlbumListAdapter(list);
        recyclerView.setAdapter(mAlbumListAdapter);
        SessionManager.getInstance(getApplicationContext()).setList(Album_cache_key,list);
    }

    @Override
    public void onGetAlbumFailure(String message) {
        //show cache data
        AppUtils.showLog(TAG,"-----onGetAlbumFailure----------");
        Toast.makeText(AlbumActivity.this,"Please check your internet connection!",Toast.LENGTH_LONG)
                .show();
        inflateDatafromCache();
    }


    /*
     * Function to display the cache data when the internet is not available
     */

    private void inflateDatafromCache() {
        List<AlbumData> albumlist = null;
        String serializedObject = SessionManager.getInstance(getApplicationContext())
                .getPrefData(Album_cache_key);
        AppUtils.showLog(TAG,"-----after list-not-len--------"+serializedObject.length());

        if(serializedObject!=null && serializedObject.length()>0)
        {
            AppUtils.showLog(TAG,"-----after list-not-NULL--------");
            Gson gson = new Gson();
            Type type = new TypeToken<List<AlbumData>>()
            {}.getType();
            albumlist = gson.fromJson(serializedObject, type);
            mAlbumListAdapter = new AlbumListAdapter(albumlist);
            recyclerView.setAdapter(mAlbumListAdapter);
        }
        else
        {
            AppUtils.showLog(TAG,"-----after list--NULL--------");
        }
    }
}
