package com.example.siddha.theoxygenorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TitleScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        Button dailysched = (Button) findViewById(R.id.dailysched);
        dailysched.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openDailySchedule();
    }

    public void openDailySchedule() {
        Intent intent = new Intent(this, DailySchedule.class);
        startActivity(intent);
    }
}