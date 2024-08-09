package com.example.siddha.teachingchildrenartificialintelligence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button btnsignificant;//declare button for the significance of ai

    private Button btnaiworks;//declare button for how ai works

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);

        btnsignificant = (Button) findViewById(R.id.btnsignificant);
        btnaiworks = (Button) findViewById(R.id.btnaiworks);
        btnsignificant.setOnClickListener(new View.OnClickListener() {
            //this listens for the click of the significance button
            @Override
            public void onClick(View v) {
                //when the significance button is clicked, view the next activity(screen or action)
                openActivitysignificant();
            }
        });
        btnaiworks.setOnClickListener(new View.OnClickListener() {//this listens for the click of the artificial intelligence works button
            @Override
            public void onClick(View v) {
                //when the artificial intelligence works button is clicked, view the next activity(screen or action)
                openActivityworks();            }

        });
    }
    public void openActivitysignificant() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        //this method opens up the next activity
    }
    public void openActivityworks() {
        Intent intent = new Intent(this, works.class);
        startActivity(intent);
        //this method opens up the how ai works activity
    }
}