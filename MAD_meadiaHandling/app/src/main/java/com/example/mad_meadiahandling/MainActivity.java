package com.example.mad_meadiahandling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    Button btn_play;
//    Button btn_pause;
//    Button btn_stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btn_play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                play();
//            }
//        });
//
//        btn_pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                pause();
//            }
//        });
//
//        btn_stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stop();
//            }
//        });
    }

    public void play(View view){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
            mediaPlayer.start();
        }else{
            mediaPlayer.start();
        }
    }

    public void pause(View view){
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void stop(View view){
        mediaPlayer.release();
        mediaPlayer = null;
    }
}