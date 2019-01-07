package com.accenture.kamal.albumlist.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kamalakannanb on 07/01/19.
 */

public class AlbumData implements Comparable{
    @SerializedName("userId")
    public int userId;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;

    public AlbumData(int userid,int id,String title)
    {
        this.userId=userid;
        this.id=id;
        this.title=title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Object o) {
        return this.getTitle().compareTo(((AlbumData) o).getTitle());

    }
}
