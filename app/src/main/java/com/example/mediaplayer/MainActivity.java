package com.example.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    Handler mainHandler = new Handler();
    BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
    TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
    TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
    SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(context, trackSelector);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
