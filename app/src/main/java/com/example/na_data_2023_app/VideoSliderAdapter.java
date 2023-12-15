package com.example.na_data_2023_app;

import static android.app.PendingIntent.getActivity;

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

public class VideoSliderAdapter extends RecyclerView.Adapter<VideoSliderAdapter.MyViewHolder> {
    private Context context;
    private String[] slidervideo;

    public VideoSliderAdapter(Context context, String[] sliderVideo) {
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
        position = position % slidervideo.length;
        Log.i("superdroid", "VideoSliderAdapter: onBindViewHolder(): slidervideo[" + position + "] value is " + slidervideo[position]);
        holder.bindSliderVideo(slidervideo[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
//        return Integer.MAX_VALUE;
//        return slidervideo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private VideoView mVideoView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoView = (VideoView) itemView.findViewById(R.id.videoSlider);
//            mVideoView.setMinimumHeight(context.getApplicationContext().getResources().getDisplayMetrics().heightPixels);
//            Log.i("superdroid", "MyViewHolder: MyViewHolder() : setMinimumHeight " + context.getApplicationContext().getResources().getDisplayMetrics().heightPixels);
            Log.i("superdroid", "MyViewHolder: MyViewHolder() : MyViewHolder is constructed");
        }

        public void bindSliderVideo(String videoURL) {
            Log.i("superdroid", "MyViewHolder: bindSliderVideo(): mVideoView height is " + mVideoView.getHeight());
            Log.i("superdroid", "MyViewHolder: bindSliderVideo(): mVideoView setting...");

            //미디어컨트롤러 추가하는 부분
            MediaController controller = new MediaController(context);
            mVideoView.setMediaController(controller);
            //비디오뷰 포커스를 요청함
            mVideoView.requestFocus();
            mVideoView.setVideoURI(Uri.parse(videoURL));

            //동영상이 재생준비가 완료되었을 때를 알 수 있는 리스너 (실제 웹에서 영상을 다운받아 출력할 때 많이 사용됨)
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Toast.makeText(context, "동영상이 준비되었습니다..\n", Toast.LENGTH_SHORT).show();

                    mVideoView.seekTo(0);
                    mVideoView.start();
                    mVideoView.pause();
                }
            });
//
//            //동영상 재생이 완료된 걸 알 수 있는 리스너
//            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    //동영상 재생이 완료된 후 호출되는 메소드
//                    Toast.makeText(context, "동영상 재생이 완료되었습니다.", Toast.LENGTH_SHORT).show();
//                }
//            });
        }

        //동영상 재생 Method
        public void playVideo() {
            //비디오를 처음부터 재생할 때 0으로 시작(파라메터 sec)
            mVideoView.seekTo(0);
            mVideoView.start();
        }

        //동영상 정지 Method
        public void stopVideo() {
            //비디오 재생 잠시 멈춤
            mVideoView.pause();
            //비디오 재생 완전 멈춤
            // videoView.stopPlayback();
            // videoView를 null로 반환 시 동영상의 반복 재생이 불가능
            // videoView = null;
        }
    }
}