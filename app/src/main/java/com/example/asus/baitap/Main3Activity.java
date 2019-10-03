package com.example.asus.baitap;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main3Activity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{
    String API_KEY ="AIzaSyAWgwbZAmk-fypUGlkNm8Hc0Lt2oNiswHM";
    YouTubePlayerView youTubePlayerView;
    String idVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        YT();

    }

    private void YT(){
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youT_video_atv3);
        youTubePlayerView.initialize(API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(idVideo);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(Main3Activity.this,123);
        }else {
            Toast.makeText(this,"loi r :))",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 123){
            youTubePlayerView.initialize(API_KEY,Main3Activity.this);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
