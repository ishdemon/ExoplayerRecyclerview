package com.codingwithmitch.recyclerviewvideoplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.codingwithmitch.recyclerviewvideoplayer.models.MediaObject;
import com.codingwithmitch.recyclerviewvideoplayer.util.Resources;
import com.codingwithmitch.recyclerviewvideoplayer.util.VerticalSpacingItemDecorator;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private VideoPlayerRecyclerView mRecyclerView;
    private FastItemAdapter<MediaObject> mediaObjectFastItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mediaObjectFastItemAdapter = new FastItemAdapter<>();
        mediaObjectFastItemAdapter.setHasStableIds(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);

        ArrayList<MediaObject> mediaObjects = new ArrayList<MediaObject>(Arrays.asList(Resources.MEDIA_OBJECTS));
        mRecyclerView.setMediaObjects(mediaObjects);
        mediaObjectFastItemAdapter.add(mediaObjects);
        mRecyclerView.setAdapter(mediaObjectFastItemAdapter);
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if (mRecyclerView != null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }
}

















