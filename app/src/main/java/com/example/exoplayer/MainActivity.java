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
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
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
    String url="http://223.110.245.167/ott.js.chinamobile.com/PLTV/3/224/3221226942/index.m3u8";
    MediaSource videoSource;
    private DataSource.Factory factory;
    SimpleExoPlayer player ;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=MainActivity.this;
        setContentView(R.layout.activity_main);
        // 1.创建一个默认TrackSelector
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector (videoTrackSelectionFactory);
        // 2.创建一个默认的LoadControl
        LoadControl loadControl = new DefaultLoadControl ();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory (context,
                Util.getUserAgent(context, "EXOPlayerTest"), bandwidthMeter);
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory ();
        url="http://223.110.245.167/ott.js.chinamobile.com/PLTV/3/224/3221226942/index.m3u8";
        //测试mp4
//        videoSource = new ExtractorMediaSource (Uri.parse(url),
//                dataSourceFactory, extractorsFactory, null, null);
        factory = new DefaultDataSourceFactory(this, "FF");
        videoSource = new HlsMediaSource.Factory(factory).createMediaSource(getUri(url));
        // 3.创建播放器
        player = ExoPlayerFactory.newSimpleInstance(context,trackSelector,loadControl);
        SimpleExoPlayerView simpleExoPlayerView= (SimpleExoPlayerView) findViewById(R.id.play_view);
        // 将player关联到View上
        simpleExoPlayerView.setPlayer(player);
        player.setPlayWhenReady(true);
        player.prepare(videoSource);
        // 准备player上的资源
    }
    private Uri getUri(String URL) {
        return Uri.parse(URL); }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}