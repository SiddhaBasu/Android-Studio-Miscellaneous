package com.example.siddha.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainScreen extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_screen);

        Button twoplayer = (Button) findViewById(R.id.singleplayerttt);
        Button computer = (Button) findViewById(R.id.multiplayerttt);

        twoplayer.setOnClickListener(this);
        computer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.singleplayerttt:
                openTwoPlayerTTT();
                break;
            case R.id.multiplayerttt:
                openComputerTTT();
                 break;
        }
    }

    private void openTwoPlayerTTT() {
        Intent intent = new Intent(this, TwoPlayerTicTacToe.class);
        startActivity(intent);
    }
    private void openComputerTTT() {
        Intent intent = new Intent(this, ComputerTicTacToe.class);
        startActivity(intent);
    }
}
