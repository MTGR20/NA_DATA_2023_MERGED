package com.example.na_data_2023_app;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class ShortsSliderAdapter extends RecyclerView.Adapter<ShortsSliderAdapter.MyViewHolder> {
    Context context;
    private String[] slidervideo;

    public ShortsSliderAdapter(Context context, String[] sliderVideo) {
        this.context = context;
        this.slidervideo = sliderVideo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_slider, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Log.i("superdroid", "ShortsSliderAdapter: onBindViewHolder(): slidervideo[" + position + "] value is " + slidervideo[position % slidervideo.length]);
        holder.bindSliderVideo(slidervideo[position % slidervideo.length], position);
    }

    @Override
    public int getItemCount() {
//        return 5;
        return Integer.MAX_VALUE;
//        return slidervideo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private VideoView mVideoView;
//        private VideoView mVideoView0;
//        private VideoView mVideoView1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            Log.i("superdroid", "MyViewHolder: MyViewHolder(): construct");

            mVideoView = (VideoView) itemView.findViewById(R.id.videoSlider);
            MediaController controller = new MediaController(context);
            mVideoView.setMediaController(controller);
            mVideoView.requestFocus();
        }

        public void bindSliderVideo(String videoURL, int position) {

            mVideoView.setVideoURI(Uri.parse(videoURL));
            mVideoView.setTag(position);

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
//                    Toast.makeText(context, "동영상이 준비되었습니다..\n", Toast.LENGTH_SHORT).show();
                    Log.i("superdroid", "MyViewHolder: bindSliderVideo(): video[" + position +"] is ready");
                }
            });

        }
    }
}