package com.codingwithmitch.recyclerviewvideoplayer.models;

import android.view.View;

import androidx.annotation.NonNull;

import com.codingwithmitch.recyclerviewvideoplayer.R;
import com.codingwithmitch.recyclerviewvideoplayer.VideoPlayerViewHolder;
import com.mikepenz.fastadapter.items.AbstractItem;

public class MediaObject extends AbstractItem<MediaObject, VideoPlayerViewHolder> {

    private String title;
    private String media_url;
    private String thumbnail;
    private String description;

    public MediaObject(String title, String media_url, String thumbnail, String description) {
        this.title = title;
        this.media_url = media_url;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    @NonNull
    @Override
    public VideoPlayerViewHolder getViewHolder(View v) {
        return new VideoPlayerViewHolder(v);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int getType() {
        return R.id.parent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.layout_video_list_item;
    }
}










