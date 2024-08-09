package com.example.siddha.thememeapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ripbtn = (Button) findViewById(R.id.ripbtn);
        Button defaultyboibtn = (Button) findViewById(R.id.defaultyboibtn);
        Button aliaintrobtn = (Button) findViewById(R.id.aliaintrobtn);
        Button defaultpeacebtn = (Button) findViewById(R.id.defaultpeacebtn);

        ripbtn.setOnClickListener(this);
        defaultyboibtn.setOnClickListener(this);
        aliaintrobtn.setOnClickListener(this);
        defaultpeacebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ripbtn:
                final MediaPlayer failsong = MediaPlayer.create(this, R.raw.sadsong);
                if (failsong.isPlaying()) {
                    failsong.pause();
                } else {
                    failsong.start();
                }
                break;
            case R.id.defaultyboibtn:
                final MediaPlayer defaultysong = MediaPlayer.create(MainActivity.this, R.raw.thedefaultyboi);
                if (defaultysong.isPlaying()) {
                    defaultysong.pause();
                } else {
                    defaultysong.start();
                }
                break;
            case R.id.aliaintrobtn:
                final MediaPlayer aliasong = MediaPlayer.create(MainActivity.this, R.raw.thealiameme);
                if (aliasong.isPlaying()) {
                    aliasong.pause();
                } else {
                    aliasong.start();
                }
                break;
            case R.id.defaultpeacebtn:
                final MediaPlayer defaultpeaceful = MediaPlayer.create(MainActivity.this, R.raw.thedefaultpeace);
                if (defaultpeaceful.isPlaying()) {
                    defaultpeaceful.pause();
                } else {
                    defaultpeaceful.start();
                }
                break;
        }
    }
}


