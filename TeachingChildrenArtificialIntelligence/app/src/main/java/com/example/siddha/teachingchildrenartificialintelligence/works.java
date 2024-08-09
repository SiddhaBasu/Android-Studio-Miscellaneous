package com.example.siddha.teachingchildrenartificialintelligence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class works extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);

        Button btnhowbrainworks = (Button) findViewById(R.id.btnhowbrainworks);
        /*
        names interexamplebtn to the button interexamplebtn
        */
        btnhowbrainworks.setOnClickListener(new View.OnClickListener() {
        /*
        this listens for the click of the interexamplebtn button
        */
            @Override
            public void onClick(View v) {
                //when the interexamplebtn button is clicked, call the method,"openinteractivepythonprogram"
                openActivitypythonp();
            }
        });
    }
    public void openActivitypythonp() {//define method that was called above
        Intent intent = new Intent(this, pythonp.class);
        startActivity(intent);//open the new activity, interactivepythonprogram
    }
}
