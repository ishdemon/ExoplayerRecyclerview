package com.codingwithmitch.recyclerviewvideoplayer;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.codingwithmitch.recyclerviewvideoplayer.models.MediaObject;
import com.mikepenz.fastadapter.FastAdapter;

import java.util.List;


public class VideoPlayerViewHolder extends FastAdapter.ViewHolder<MediaObject> {

    FrameLayout media_container;
    TextView title;
    ImageView thumbnail, volumeControl;
    ProgressBar progressBar;
    View parent;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_control);
    }

    @Override
    public void bindView(MediaObject mediaObject, List<Object> payloads) {
        parent.setTag(this);
        title.setText(mediaObject.getTitle());
        GlideApp.with(thumbnail.getContext()).load(mediaObject.getThumbnail()).transition(DrawableTransitionOptions.withCrossFade()).into(thumbnail);
    }

    @Override
    public void unbindView(MediaObject item) {

    }

}














