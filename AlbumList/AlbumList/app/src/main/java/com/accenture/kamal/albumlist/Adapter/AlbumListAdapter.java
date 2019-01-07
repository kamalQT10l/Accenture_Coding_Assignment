package com.accenture.kamal.albumlist.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.accenture.kamal.albumlist.Model.AlbumData;
import com.accenture.kamal.albumlist.R;
import com.accenture.kamal.albumlist.Utils.AppUtils;

import java.util.List;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder> {

    private List<AlbumData> albumData;

    public AlbumListAdapter(List<AlbumData> list){

        this.albumData = list;
    }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_data_row,viewGroup,false);

        return new AlbumViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {
        albumViewHolder.mtitle.setText(albumData.get(i).getTitle()+"");
    }

    @Override
    public int getItemCount() {
        return albumData.size();
    }


    class AlbumViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtitle;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            mtitle=(TextView)itemView.findViewById(R.id.mtitle);
        }
    }

}



