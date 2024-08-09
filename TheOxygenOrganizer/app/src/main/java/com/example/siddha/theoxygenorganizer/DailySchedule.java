package com.example.siddha.theoxygenorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.siddha.theoxygenorganizer.R.id.activity;

public class DailySchedule extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_TEXT = "com.example.siddha.theoxygenorganizer.EXTRA_TEXT";

    private EditText editTime;
    private EditText editActivity;
    private Button confirm;

    String activityone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule);

        editTime = (EditText) findViewById(R.id.timedate);
        editActivity = (EditText) findViewById(activity);
        confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(this);

        editTime.addTextChangedListener(loginTextWatcher);
        editActivity.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = editTime.getText().toString().trim();
            String passwordInput = editActivity.getText().toString().trim();

            confirm.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "This Activity has been added to your schedule", Toast.LENGTH_SHORT).show();
        openTaskList();
    }

    private void openTaskList() {
        EditText activity = (EditText) findViewById(R.id.activity);
        String nameactivity = activity.getText().toString();

        Intent intent = new Intent(this, TaskList.class);
        intent.putExtra(EXTRA_TEXT, nameactivity);
        startActivity(intent);
    }
}