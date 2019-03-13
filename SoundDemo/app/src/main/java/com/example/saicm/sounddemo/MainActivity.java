package com.example.saicm.sounddemo;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button playpause;
    Button playstop;
    Button restart;
    Button buttontime;

    SeekBar seekBar;

    TextView time;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playpause = findViewById(R.id.buttonplaypause);
        playstop = findViewById(R.id.buttonplaystop);
        restart = findViewById(R.id.buttonrestart);
        buttontime = findViewById(R.id.buttontime);
        time = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });

        playstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    mediaPlayer.start();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                }
            }
        });

        buttontime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setText(mediaPlayer.getCurrentPosition()/1000+" seconds");
            }
        });

        final Handler handler = new Handler();
//        seekBar.setMax(mediaPlayer.getDuration());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition()/1000);
                }
                handler.postDelayed(this, 1000);
            }
        });

    }
}
