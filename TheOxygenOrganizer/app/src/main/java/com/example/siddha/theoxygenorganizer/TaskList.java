package com.example.siddha.theoxygenorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Intent intent = getIntent();
        String nameactivity = intent.getStringExtra(DailySchedule.EXTRA_TEXT);

        TextView activityone = (TextView) findViewById(R.id.activityone);

        activityone.setText(nameactivity);

    }
}
