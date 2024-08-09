package com.example.siddha.teachingchildrenartificialintelligence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button btnstats;//declare button for the ai stats

    private Button btnmodernex;//declare button for the examples of modern ai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity2);

        btnstats = (Button) findViewById(R.id.btnstats);
        //finds the button "btnstats"
        btnmodernex = (Button) findViewById(R.id.btnmodernex);
        //find the button "btnmodernex"
        btnstats.setOnClickListener(new View.OnClickListener() {//set a new onclicklistener for the button "btnstats"
            @Override
            public void onClick(View v) {
                openActivityStatistics();//when this button is clicked, call method "openActivityStatistics"
            }
        });
        btnmodernex.setOnClickListener(new View.OnClickListener() {/*set a new onclicklistener for the button
        "btnmodernex"*/
            @Override
            public void onClick(View v) {
                //when this button is clicked, call method "openActivityaiexamples"
                openActivityaiexamples();
            }
        });
    }
    public void openActivityStatistics() {//define method that was called above
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);//starts the new activity, statistics
    }

    public void openActivityaiexamples() {//define method that was called above
        Intent intent = new Intent(this, aiexamples.class);
        startActivity(intent);//starts the new activity, aiexamples
    }
}