package com.example.exoplayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recvlerView;
    private bofangListAdapter listAdapter;
    private List<bofang> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recvlerView=findViewById(R.id.recycler);
        listAdapter=new bofangListAdapter(this.data, new ChannelClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.i("ffplay", "Clicked " + view + " on " + position);
                if (position < data.size()) {
                    bofang c = data.get(position);
                    Intent intent = new Intent(MainActivity.this,liveActivity.class);
                    intent.putExtra("bofang",c);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "wuyongpindao", Toast.LENGTH_SHORT);
                }
            }
        });
        recvlerView.setAdapter(listAdapter);
        recvlerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        DataLab lab = new DataLab(this);
        this.data = lab.getbofangs("data.json");
    }
}