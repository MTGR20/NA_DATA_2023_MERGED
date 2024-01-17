package com.example.na_data_2023_app;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class ShortsActivity extends Fragment {
    Activity activity;
    ViewPager2 sliderViewPager;
    int currentPostion;
    private String[] videos = new String[] {
//            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
//            "android.resource://" + "com.example.na_data_2023_app" + "/raw/sample1",
//            "android.resource://" + activity.getPackageName() + "/raw/sample1",
            "android.resource://" + "com.example.na_data_2023_app" + "/raw/video1",
            "android.resource://" + "com.example.na_data_2023_app" + "/raw/video2",
            "android.resource://" + "com.example.na_data_2023_app" + "/raw/video3",
            "android.resource://" + "com.example.na_data_2023_app" + "/raw/video4",
            "android.resource://" + "com.example.na_data_2023_app" + "/raw/video5",
    };
    private VideoView mVideoView = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.i("superdroid", "VideoActivity: onAttach():");

        if (context instanceof Activity)
            activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_shorts, container, false);

        sliderViewPager = v.findViewById(R.id.sliderViewPager);
        sliderViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        sliderViewPager.setOffscreenPageLimit(1);

        ShortsSliderAdapter shortsSliderAdapter = new ShortsSliderAdapter(activity, videos);
        sliderViewPager.setAdapter(shortsSliderAdapter);

        Log.i("superdroid", "VideoActivity: onCreateView():");

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrollStateChanged(int position) {
//                Log.i("superdroid", "VideoActivity: onCreateView(): onPageScrollStateChanged(): position is " + position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                playVideo(position);
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("superdroid", "VideoActivity: onViewCreated():");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("superdroid", "VideoActivity: onResume(): ");
        if (mVideoView != null && !mVideoView.isPlaying()) {
            mVideoView.seekTo(0);
            mVideoView.start();
            mVideoView.pause();
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    mVideoView.start();
                }
            }, 1800);
        }
    }

    private void playVideo(int position) {
        currentPostion = position;

        if (mVideoView != null) mVideoView.pause();
//                mVideoView = sliderViewPager.findViewById(R.id.videoSlider);
        mVideoView = sliderViewPager.findViewWithTag(position);

//                Log.i("superdroid", "VideoActivity: onCreateView(): onPageSelected(): position is " + position);

        if (!mVideoView.isPlaying()) {
            mVideoView.seekTo(0);
            mVideoView.start();
        }
        Log.i("superdroid", "VideoActivity: playVideo(): " + position + " video start");

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                        Toast.makeText(activity, "동영상 재생이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                Log.i("superdroid", "VideoActivity: onCreateView(): onPageSelected(): video end");
                mVideoView.seekTo(0);
                mVideoView.start();
            }
        });
    }
}