package com.example.exoplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
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

    public class MainActivity2 extends AppCompatActivity {
        private static final String TAG="MainActivity2";
        String url="http://223.110.245.167/ott.js.chinamobile.com/PLTV/3/224/3221226942/index.m3u8";
        MediaSource videoSource;
        private DataSource.Factory factory;
        SimpleExoPlayer player ;
        MainActivity2 context;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG,"onCreate(Bundle)called");
            context= com.example.exoplayer.MainActivity2.this;
            setContentView(R.layout.activityexoplayer_view);
            Button btn_back=(Button)findViewById (R.id.btn_back);
            btn_back.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    finish ();
                }
            });
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
            String url = getIntent().getStringExtra("url");

            this.url =url;
            //测试mp4
//        videoSource = new ExtractorMediaSource (Uri.parse(url),
//                dataSourceFactory, extractorsFactory, null, null);
            factory = new DefaultDataSourceFactory(this, "FF");
            videoSource = new HlsMediaSource.Factory(factory).createMediaSource(getUri(this.url));
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
