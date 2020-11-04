package com.example.CodeIt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends YouTubeBaseActivity {

    ImageView mainImageView;
    TextView title, description;

    String data1, data2;
    int myImage;

    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        btnPlay =(Button) findViewById(R.id.btnPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                List<String> videoList = new ArrayList<>();
//                videoList.add("KJgsSFOSQv0");
//                videoList.add("CpG3oATGIs");
//                youTubePlayer.loadVideos(videoList);
                if(data1.equals("C"))
                    youTubePlayer.loadPlaylist("PLBlnK6fEyqRhX6r2uhhlubuF5QextdCSM");
                else if(data1.equals("C++"))
                    youTubePlayer.loadPlaylist("PLVlQHNRLflP8_DGKcMoRw-TYJJALgGu4J");
                else if(data1.equals("C#"))
                    youTubePlayer.loadPlaylist("PLAC325451207E3105");
                else if(data1.equals("Java"))
                    youTubePlayer.loadPlaylist("PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al");
                else if(data1.equals("Javascript"))
                    youTubePlayer.loadPlaylist("PLsyeobzWxl7qtP8Lo9TReqUMkiOp446cV");
                else if(data1.equals("Kotlin"))
                    youTubePlayer.loadPlaylist("PLlxmoA0rQ-LwgK1JsnMsakYNACYGa1cjR");
                else if(data1.equals("Python"))
                    youTubePlayer.loadPlaylist("PLu0W_9lII9agICnT8t4iYVSZ3eykIAOME");
                else if(data1.equals("Ruby"))
                    youTubePlayer.loadPlaylist("PL1512BD72E7C9FFCA");
                else if(data1.equals("Swift"))
                    youTubePlayer.loadPlaylist("PLMRqhzcHGw1b89DXHOVA77ozWXWmuBkWX");
                else
                    youTubePlayer.loadPlaylist("PL4cUxeGkcC9gUgr39Q_yD6v-bSyMwKPUI");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){

         data1 = getIntent().getStringExtra("data1");
         data2 = getIntent().getStringExtra("data2");
         myImage = getIntent().getIntExtra("myImage", 1);

        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }


}