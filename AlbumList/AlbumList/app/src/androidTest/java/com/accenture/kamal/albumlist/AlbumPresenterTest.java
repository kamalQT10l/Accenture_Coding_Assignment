package com.accenture.kamal.albumlist;

import android.support.test.espresso.core.deps.guava.base.Verify;
import android.support.test.runner.AndroidJUnit4;

import com.accenture.kamal.albumlist.Core.Helpers.GetAlbumHelper;
import com.accenture.kamal.albumlist.Core.Intractor.AlbumIntractor;
import com.accenture.kamal.albumlist.Core.Presenter.AlbumPresenter;
import com.accenture.kamal.albumlist.Model.AlbumData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by kamalakannanb on 07/01/19.
 */
@RunWith(AndroidJUnit4.class)
public class AlbumPresenterTest {

    @Mock
    AlbumPresenter presenter;

    @Mock
    GetAlbumHelper.View  view;


    @Test
    public void onGetAlbumsucces()
    {
             MockitoAnnotations.initMocks(this);
             presenter = new AlbumPresenter(view);
             presenter.onSuccess(getList());
    }


    public List<AlbumData> getList() {
        ArrayList<AlbumData> album = new ArrayList<>();
        album.add(new AlbumData(1,10,"Faded"));
        album.add(new AlbumData(2,11,"Love me like you do"));
        return album;
    }
}
